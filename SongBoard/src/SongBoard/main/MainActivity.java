package SongBoard.main;
import SongBoard.main.Source;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class MainActivity_Frame extends Frame implements ActionListener
{
	private Button[][] bt = new Button[10][10];
	private boolean[][] bt_end = new boolean[10][10]; 
	private Panel p1 = new Panel();
	private Font ft = new Font("",Font.BOLD, 20);
	private Source s = new Source();
	
	MainActivity_Frame(String title)
	{
		super(title);
		super.setSize(1024,730);
		for ( int i = 0; i < 10 ; i ++ )
		{
			for ( int j = 0 ; j < 10 ; j ++ )
			{
				bt_end[i][j] = false;
			}
		}
		init();
		super.setResizable(false);
		super.setVisible(true);
		super.addWindowListener(new EventHandler());
	}
	
	void fillButton()
	{
		int count = 1;
		for (int i = 0 ; i < 10 ; i ++ )
		{
			for (int j = 0 ; j < 10; j ++ )
			{
				bt[i][j] = new Button(String.valueOf(i*10 + j + 1));
				bt[i][j].setFont(ft);
				bt[i][j].setBackground(new Color(0,0,0));
				bt[i][j].setForeground(new Color(255,255,255));
				bt[i][j].addActionListener(this);
			}
		}
	}
	
	void setP()
	{
		p1.setLayout(new GridLayout(4,4,10,10));
		for ( int i = 0 ; i < 10 ; i ++ )
		{
			for ( int j = 0 ; j < 10 ; j ++ )
			{
				p1.add(bt[i][j]);
			}
		}
	}
	
	void init()
	{
		fillButton();
		setP();
		this.add("Center",p1);
	}
	
	class EventHandler implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			arg0.getWindow().setVisible(false);
			System.exit(0);
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class Result_Frame extends JDialog 
	{
		JLabel e = new JLabel("");
		public Result_Frame(String str)
		{
			
			getContentPane().add(e);
			
			e.setText(str.toString());
			e.setHorizontalAlignment(JLabel.CENTER);
			e.setFont(new Font("",Font.BOLD,80));
			
			this.setSize(1000,300);
			this.setModal(true);
			this.setVisible(true);
			
			this.setLocation(500,500);
			//this.addWindowListener(new EventHandler());
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int n = Integer.parseInt(arg0.getActionCommand())-1;
		JOptionPane.showMessageDialog(this,arg0.getSource());
		new Result_Frame(s.songs[n]);
		bt_end[n/10][n%10] = true;
		
	}
	
}

public class MainActivity {
	
	public static void main(String[] args)
	{
		MainActivity_Frame newframe = new MainActivity_Frame("µµÀü Âù¾ç 100°î");
	}
	
}
