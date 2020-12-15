package bsu.rfe.java.group9.lab2.Minchyonok.varА9;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.BorderFactory;
	import javax.swing.Box;
	import javax.swing.ButtonGroup;
	import javax.swing.JButton;

	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JRadioButton;
	import javax.swing.JTextField;
	        @SuppressWarnings("serial")
	        public class MainFrame extends JFrame {
		private static final int WIDTH = 400;
		private static final int HEIGHT = 320;
		   private JTextField textfieldX;
		   private JTextField textfieldY;
		   private JTextField textfieldZ;
		   private JTextField field_result;
		   private JTextField field_sum;
		   private ButtonGroup radioButton = new ButtonGroup();
		   private Box hboxFormulaType = Box.createHorizontalBox();
		   private int formula = 1;
		   public Double result = 0.0;
		   public Double sum;

		   public Double calculatel1(Double x, Double y, Double z) {
		      return Math.sin(Math.sin(y)+(Math.pow((Math.E),Math.cos(y))) + (z * z))*(Math.pow(Math.sin(Math.PI*y*y)+Math.exp(x*x),1.0D/4.0D)); 
		   }
		   public Double calculate2(Double x, Double y, Double z) {
		      return (Math.atan(Math.pow(z, 1.0D/x)))/(y * y + z*Math.sin(Math.exp(x)));
		   }

		   private void addRadioButton(String buttonName, int formula) {
		      JRadioButton button = new JRadioButton(buttonName);
		      button.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						MainFrame.this.formula = formula;	
					}
				});
		      radioButton.add(button);
		      hboxFormulaType.add(button);
		   }

		   public MainFrame() {
		      super("Вычисление формулы");
		      setSize(WIDTH,HEIGHT);
		      Toolkit kit = Toolkit.getDefaultToolkit();
		      setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);
		      hboxFormulaType.add(Box.createHorizontalGlue());
		      addRadioButton("Формула 1", 1);
		      addRadioButton("Формула 2", 2);
		      radioButton.setSelected(radioButton.getElements().nextElement().getModel(),true);
		      hboxFormulaType.add(Box.createHorizontalGlue());
		      Box XBox = Box.createHorizontalBox();
		      JLabel x = new JLabel(" Х:");
		      
		      XBox.add(x);
		      
		      Box YBox = Box.createHorizontalBox();
		      JLabel y = new JLabel(" Y:");
		      YBox.add(y);
		      
		      Box ZBox = Box.createHorizontalBox();
		      JLabel z = new JLabel(" Z:");
		      ZBox.add(z);
		      
		      textfieldX = new JTextField("0", 8);
		      XBox.add(Box.createHorizontalStrut(1));
		      XBox.add(this.textfieldX);
		      textfieldX.setMaximumSize(textfieldX.getPreferredSize());
		      textfieldY = new JTextField("0", 8);
		      YBox.add(Box.createHorizontalStrut(1));
		      YBox.add(textfieldY);
		      textfieldY.setMaximumSize(textfieldY.getPreferredSize());
		      textfieldZ = new JTextField("0", 8);
		      ZBox.add(Box.createHorizontalStrut(1));
		      ZBox.add(textfieldZ);
		      textfieldZ.setMaximumSize(textfieldZ.getPreferredSize());
		      JLabel Result = new JLabel("Результат");
		      field_result = new JTextField("0", 15);
		      Box hboxResult = Box.createHorizontalBox();
		      hboxResult.add(Box.createHorizontalGlue());
		      hboxResult.add(Result);
		      hboxResult.add(Box.createHorizontalStrut(10));
		      hboxResult.add(field_result);
		      field_result.setMaximumSize(field_result.getPreferredSize());
		      hboxResult.add(Box.createHorizontalGlue());
		      hboxResult.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		      JButton buttonCalc = new JButton("Вычислить");
		      buttonCalc.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ev)
					{
						try
						{
							Double x = Double.parseDouble(textfieldX.getText());
							Double y = Double.parseDouble(textfieldY.getText());
							Double z = Double.parseDouble(textfieldZ.getText());
							if(formula == 1)
								MainFrame.this.result = calculatel1(x,y,z);
							else MainFrame.this.result = calculate2(x,y,z);
							field_result.setText(MainFrame.this.result.toString());
						}
						catch(NumberFormatException ex)
						{
							JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи числа с " +
									"плавающей точкой","Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);   
						}
					}
				});
		      JLabel labelForRes = new JLabel("Сумма");
		      field_sum = new JTextField("0", 15);
		      field_sum.setMaximumSize(this.field_sum.getPreferredSize());
		      Box hboxRes = Box.createHorizontalBox();
		      hboxRes.add(Box.createHorizontalGlue());
		      hboxRes.add(labelForRes);
		      hboxRes.add(Box.createHorizontalStrut(10));
		      hboxRes.add(field_sum);
		      hboxRes.add(Box.createHorizontalGlue());
		      hboxRes.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		      sum=0.0;
				JButton buttonSum = new JButton("M+");
				buttonSum.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ev) 
					{
						
						sum = sum + result;
						field_sum.setText(sum.toString());
					}
				}
				);

				JButton buttonMC = new JButton("MC");
				buttonMC.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ev) 
					{
						sum=0.0;
						field_sum.setText(sum.toString());
						
					}});

				JButton buttonReset = new JButton("Очистить поля"); 
				buttonReset.addActionListener(new ActionListener() 
				{ 		
					public void actionPerformed(ActionEvent ev) 
					{ 
						textfieldX.setText("0"); 
						textfieldY.setText("0"); 
						textfieldZ.setText("0");
						field_result.setText("0");
						result=0.0;
					}
				}); 

				Box hboxButtons = Box.createHorizontalBox();
				hboxButtons.add(Box.createHorizontalGlue()); 
				hboxButtons.add(buttonCalc); 
				hboxButtons.add(Box.createHorizontalStrut(0)); 
				hboxButtons.add(buttonReset); 
				hboxButtons.add(Box.createHorizontalStrut(1040)); 
				hboxButtons.add(buttonSum); 
				hboxButtons.add(Box.createHorizontalStrut(0)); 
				hboxButtons.add(buttonMC); 
				hboxButtons.add(Box.createHorizontalGlue()); 
				hboxButtons.setBorder( BorderFactory.createLineBorder(Color.RED)); 

				Box contentBox = Box.createVerticalBox(); 
				
				contentBox.add(hboxFormulaType);
				contentBox.add(XBox);		
				contentBox.add(YBox);
				contentBox.add(ZBox);	
					
				contentBox.add(Box.createVerticalStrut(5));
				contentBox.add(hboxRes); 
				contentBox.add(Box.createVerticalStrut(5));
				contentBox.add(hboxResult); 
				contentBox.add(hboxButtons); 
				getContentPane().add(contentBox, BorderLayout.CENTER);
			}
			public static void main(String[] args) 
			{ 
				MainFrame frame = new MainFrame(); 
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true); 

			}
		}