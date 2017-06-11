import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class MatrixPanel extends JPanel{

	Matrix mat;

	public MatrixPanel(Matrix mat){
		this.mat = mat;
		setBackground(Color.BLACK);
	}


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.ORANGE);
		int w = getWidth()/getMatrix().getN();
		int h = getHeight()/getMatrix().getM();

		//draws a rect if the value of the element is 0, else fills in said rect.
		for(int i = 0; i < getMatrix().getM(); i++){
			for(int j = 0; j < getMatrix().getN(); j++){
				if(getMatrix().getVal(i, j) == 0.0) g.drawRect(w*j, h*i, w, h);
				else g.fillRect(w*j, h*i, w, h);
			}
		}

	}

	public Matrix getMatrix(){
		return mat;
	}
	public void setMatrix(Matrix mat){
		this.mat = mat;
	}
}




public class MatrixFrame extends JFrame{
	//question graphics:
	private int X = 600, Y = 600;
	MatrixPanel mpan;
	Matrix mat;
	JButton but;
	JPanel control;
	//passes the matrix from where it's instantiated into the panel.
	public MatrixFrame(Matrix mat){
		this.mat = mat;

		mpan = new MatrixPanel(mat);
		control = new JPanel();
		but = new JButton("Exponentiate");
		control.add(but);

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		setLayout(new BorderLayout());
		getContentPane().add(mpan, BorderLayout.CENTER);
		getContentPane().add(control, BorderLayout.SOUTH);

		setBackground(Color.GRAY);
		setTitle("Matrix Exponentials.");
		setSize(X, Y);
		setLocation(200, 0);
		setVisible(true);

		//this allows you to exponentiate the matrix once the button's pressed.
		exponentiate();

	}

	public void exponentiate(){
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Matrix exp = Matrix.exponentialMatrix(mat, 50);
				mpan.setMatrix(exp);
				repaint();
			}
		});
	}
}
