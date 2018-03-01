package michele.lombardi.mytimer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import michele.lombardi.mycomponents.TitleLabel;

public class MyTimer extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Font font = new Font (Font.DIALOG, Font.BOLD, 36);
	private TimerPanel timerPanel = new TimerPanel(0, font);
	
	public MyTimer(){
		initGUI();
		setTitle("My Timer");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initGUI(){
		TitleLabel titleLabel = new TitleLabel("My Timer");
		add(titleLabel, BorderLayout.PAGE_START);
		
		JPanel centerPanel = new JPanel();
		timerPanel.setBackground(Color.MAGENTA);
		centerPanel.add(timerPanel);
		centerPanel.setBackground(Color.MAGENTA);
		add(centerPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		
		JButton hoursButton = new JButton("Hour");
		hoursButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addAnHour();
			}
		});
		buttonPanel.add(hoursButton);
		
		JButton minutesButton = new JButton("Minutes");
		minutesButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addAMinute();
			}
		});
		buttonPanel.add(minutesButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clear();
			}
		});
		buttonPanel.add(clearButton);
		
		add(buttonPanel, BorderLayout.PAGE_END);
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				start();
			}
		});
		buttonPanel.add(startButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				stop();
			}
		});
		buttonPanel.add(stopButton);
	}
	
	private void start(){
		timerPanel.start();
	}
	
	private void stop(){
		timerPanel.stop();
	}
	
	private void addAnHour(){
		long time = timerPanel.getTime();
		time += 3600;
		timerPanel.setTime(time);
	}
	
	private void addAMinute(){
		long time = timerPanel.getTime();
		time += 60;
		timerPanel.setTime(time);
	}
	
	private void clear(){
		timerPanel.stop();
		timerPanel.setTime(0);
	}

	public static void main(String[] args) {
		try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		} catch (Exception e){}
		
		EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new MyTimer();
            }   
        });

	}

}
