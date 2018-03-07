package GUI.Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
public class calculator {
	static double a;
	static String pa[],pb[];
	static DecimalFormat format = new DecimalFormat("0.#");
	static double Ima,Rea,Imb,Reb,Imn,Ren,par,pat,pbr,pbt,pnr,pnt,x;
	static int op;
	public static int[] sort(int a[]) {
		int c = 0,d,h;
		while(c < a.length){
			d = c+1;
			while(d < a.length) {
			    if(a[c] > a[d]) {
			    	h = a[c];
			    	a[c] = a[d];
			    	a[d] = h;
			    }
			    d++;
			}
			c++;
		}
		return a;
	}
	public static double sin(double r) {
		double c = 1,h,n = 1,f,t = 0,sin = 0;
		while(c < 100) {
			h = n;
			f = 1;
			while(h > 1) {
				f = f*(h--);
			}
			t = Math.pow(r,n)/f;
			if(c%2 == 0)
			    sin = sin-t;
			else
				sin = sin+t;
			n+=2;
			c++;
		}
		return Math.round(sin*10000000000.0)/10000000000.0;
	}
	public static double cos(double r) {
		double c = 1,h,n = 0,f,t = 0,cos = 0;
		while(c < 100) {
			h = n;
			f = 1;
			while(h > 1) {
				f = f*(h--);
			}
			t = Math.pow(r,n)/f;
			if(c%2 == 0)
			    cos = cos-t;
			else
				cos = cos+t;
			n+=2;
			c++;
		}
		return Math.round(cos*10000000000.0)/10000000000.0;
	}
	public static double arcsin(double a) {
		if(a == 1)
			return 90;
		else if(a == -1)
			return -90;
		else {
		    double c = 1,n = 1,t,f = 1,r = 1,arcsin = 0;
		    while(c < 10000) {
			    if(c > 1) {
			        f = (r/(r+1))*f;
			        r+=2;
			    }
			    t = Math.pow(a,n)/n;
			    arcsin = (t*f)+arcsin;
			    n+=2;
			    c++;
		    }
		    arcsin = Math.toDegrees(arcsin);
		    return Math.round(arcsin*10000000000.0)/10000000000.0;
		}
	}
	public static double arccos(double a) {
		if((a == 1))
			return 0;
		else if(a == -1)
			return 180;
		else {
		    double c = 1,n = 1,t,f = 1,r = 1,arcsin = 0,arccos = 0;
		    while(c < 10000) {
			    if(c > 1) {
			        f = (r/(r+1))*f;
			        r+=2;
			    }
			    t = Math.pow(a,n)/n;
			    arcsin = (t*f)+arcsin;
			    n+=2;
			    c++;
		    }
		    arccos = (Math.PI/2)-arcsin;
		    arccos = Math.toDegrees(arccos);
		    return Math.round(arccos*10000000000.0)/10000000000.0;
		}
	}
	public static double arctan(double a) {
		return arcsin(a/(Math.sqrt((a*a)+1)));
	}
	public static void main(String[] ar) {
		JFrame f = new JFrame("Calculator");
		f.setSize(1000,290);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		p.setLayout(null);
		JButton option[] = new JButton[16];
		option[0] = new JButton("+");
		option[1] = new JButton("-");
		option[2] = new JButton("*");
		option[3] = new JButton("/");
		option[4] = new JButton("x\u221A(y)");
		option[5] = new JButton("xʸ");
		option[6] = new JButton("x!");
		option[7] = new JButton("Sin");
		option[8] = new JButton("Cos");
		option[9] = new JButton("Tan");
		option[10] = new JButton("Cot");
		option[11] = new JButton("Sec");
		option[12] = new JButton("Cosec");
		option[13] = new JButton("Log\u2093y");
		option[14] = new JButton("Sort");
		option[15] = new JButton("=");
		JButton pi = new JButton("\u03C0");
		JButton i = new JButton("i");
		i.setBounds(920,6,50,30);
		i.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		pi.setBounds(830,210,50,30);
		pi.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		JCheckBox inv = new JCheckBox("Inverse");
		inv.setBounds(730,210,100,30);
		inv.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		JCheckBox deg = new JCheckBox("Degrees", true);	
		deg.setBounds(880,210,110,30);
		deg.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		JTextArea input = new JTextArea("Enter");
		input.setBounds(730,40,260,170);
		input.setBorder(BorderFactory.createEtchedBorder());
		input.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		JCheckBox com = new JCheckBox("Complex mode", false);	
		com.setBounds(730,10,185,30);
		com.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		int c = 0,x = 10,y = 10;
		while(c < 16) {
			option[c].setBounds(x,y,170,50);
			option[c].setFont(new Font("Times New Roman", Font.PLAIN, 25));
			p.add(option[c]);
			c++;
			y+=60;
			if(c%4 == 0) {
				x+=180;
				y = 10;
			}
		}
		option[0].setToolTipText("Add 2 numbers x + y");
		option[1].setToolTipText("Subtract 2 numbers x - y");
		option[2].setToolTipText("Multiply 2 numbers x * y");
		option[3].setToolTipText("Divide 2 numbers x / y");
		option[4].setToolTipText("The xth root of y");
		option[5].setToolTipText("x to the power y");
		option[6].setToolTipText("x(x-1)(x-2)...1");
		c = 7;
		while(c < 13)
			option[c].setToolTipText("Trigonometric function "+option[c++].getText());
		option[13].setToolTipText("Log x to the base y");
		option[14].setToolTipText("Enter an array of numbers seprated by space to be sorted");
		pi.setToolTipText("Math Constant \u03C0");
		inv.setToolTipText("Inverse Trigonometric and AntiLog functions");
		deg.setToolTipText(" Degrees or Radians");
		p.add(pi);
		p.add(i);
		p.add(inv);
		p.add(deg);
		p.add(com);
		p.add(input);
		f.add(p);
		f.setVisible(true);
		input.requestFocus();
		inv.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int d = 7;
				if(inv.isSelected()) {
					if(com.isSelected()) {
						option[6].setText("To Rect.");
						option[6].setToolTipText("Convert the given complex number to Rectangular form");
					}
					while(d < 13) {
						option[d].setText("arc"+option[d].getText());
						option[d].setToolTipText("Trigonometric function "+option[d].getText());
						d++;
					}
					option[13].setText("AntiLog y(x)");
					option[13].setToolTipText("AntiLog x to the base y");
					pi.setText("e");
					pi.setToolTipText("Math Constant e");
				}
				else {
					if(com.isSelected()) {
						option[6].setText("To Polar");
						option[6].setToolTipText("Convert the given complex number to polar form");
					}
					while(d < 13) {
						String split[] = option[d].getText().split("c",2);
						option[d].setText(split[1]);
						option[d].setToolTipText("Trigonometric function "+option[d].getText());
						d++;
					}
					option[13].setText("Log y(x)");
					option[13].setToolTipText("Log x to the base y");
					pi.setText("\u03C0");
					pi.setToolTipText("Math Constant \u03C0");
				}
			}
		});
		deg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(deg.isSelected())
					deg.setText("Degrees");
				else
					deg.setText("Radians");
			}
		});
		com.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(com.isSelected()) {
					input.setText("Enter in x +yi format");
					if(inv.isSelected()) {
						option[6].setText("To Rect.");
						option[6].setToolTipText("Convert the given complex number to Rectangular form");
					}
					else {
						option[6].setText("To Polar");
						option[6].setToolTipText("Convert the given complex number to polar form");
					}
					int s = 7;
					while(s < 15)
						option[s++].setEnabled(false);
				}	
				else {
					option[6].setText("x!");
					option[6].setToolTipText("x(x-1)(x-2)...1");
					int s = 7;
					input.setText("Enter");
					while(s < 15)
						option[s++].setEnabled(true);
				}
			}
		});
		i.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(com.isSelected())
					input.append("i");
			}
		});
		pi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inv.isSelected())
					input.append(""+Math.E);
				else
					input.append(""+Math.PI);
			}
		});
		option[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(com.isSelected()) {
					pa = input.getText().split(" ");
				}
				else
					a = Double.parseDouble(input.getText());
				input.setText("");
				op = 1;
				input.requestFocus();
			}
		});
		option[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(com.isSelected()) {
					pa = input.getText().split(" ");
				}
				else
					a = Double.parseDouble(input.getText());
				input.setText("");
				op = 2;
				input.requestFocus();
			}
		});
		option[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(com.isSelected()) {
					pa = input.getText().split(" ");
				}
				else
					a = Double.parseDouble(input.getText());
				input.setText("");
				op = 3;
				input.requestFocus();
			}
		});
		option[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(com.isSelected()) {
					pa = input.getText().split(" ");
				}
				else
					a = Double.parseDouble(input.getText());
				input.setText("");
				op = 4;
				input.requestFocus();
			}
		});
		option[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(com.isSelected()) {
					pa = input.getText().split(" ");
				}
				else
					a = Double.parseDouble(input.getText());
				input.setText("");
				op = 5;
				input.requestFocus();
			}
		});
		option[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(com.isSelected()) {
					pa = input.getText().split(" ");
				}
				else
					a = Double.parseDouble(input.getText());
				input.setText("");
				op = 6;
				input.requestFocus();
			}
		});
		option[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(com.isSelected()) {
					if(inv.isSelected()) {
						String part[] = input.getText().split("<");
						pnr = Double.parseDouble(part[0]);
						pnt = Double.parseDouble(part[1]);
						if(deg.isSelected()) {
							Ren = pnr*cos(Math.toRadians(pnt));
							Imn = pnr*sin(Math.toRadians(pnt));
						}
						else{
							Ren = pnr*cos(pnt);
							Imn = pnr*sin(pnt);
						}
						Ren = Math.round(Ren*10000000000.0);
						Ren = Ren/10000000000.0;
						Imn = Math.round(Imn*10000000000.0);
						Imn = Imn/10000000000.0;
						if(Ren == 0) {
							if(Imn == 0)
								input.setText("0");
							else
								input.setText(((Imn%1==0)?format.format(Imn):Imn)+"i");
						}
						else {
							if(Imn > 0)
								input.setText((Ren%1==0?format.format(Ren):Ren)+" +"+((Imn%1==0)?format.format(Imn):Imn)+"i");
							else if(Imn == 0)
								input.setText(""+((Ren%1==0)?format.format(Ren):Ren));
							else if(Imn < 0)
								input.setText(((Ren%1==0)?format.format(Ren):Ren)+" "+((Imn%1==0)?format.format(Imn):Imn)+"i");
						}
					}
					else {
						pa = input.getText().split(" ");
						pa[1] = pa[1].replaceAll("i","");
						Rea = Double.parseDouble(pa[0]);
						Ima = Double.parseDouble(pa[1]);
						par = Math.sqrt(Rea*Rea+Ima*Ima);
						pat = arccos(Rea/par);
						par = Math.round(par*10000000000.0);
						par = par/10000000000.0;
						if(!deg.isSelected()) {
							pat = Math.toRadians(pat);
							pat = Math.round(pat*10000000000.0);
							pat = pat/10000000000.0;
							input.setText(format.format(par)+"<"+pat);
						}
						else {
							pat = Math.round(pat*10000000000.0);
							pat = pat/10000000000.0;
							input.setText(format.format(par)+"<"+format.format(pat));
						}
					}
				}
				else {
					long f = 1;
					long b = Long.parseLong(input.getText());
					while(b > 0) {
						f = b*f;
						b--;
					}
					input.setText(""+f);
				}
			}
		});
		option[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Double.parseDouble(input.getText());
				if(inv.isSelected()) {
					if(deg.isSelected())
						input.setText(""+arcsin(a));
					else
						input.setText(""+Math.toRadians(arcsin(a)));
						
				}
				else {
					if(deg.isSelected())
						input.setText(""+sin(Math.toRadians(a)));
					else
						input.setText(""+sin(a));
				}
			}
		});
		option[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Double.parseDouble(input.getText());
				if(inv.isSelected()) {
					if(deg.isSelected())
						input.setText(""+arccos(a));
					else
						input.setText(""+Math.toRadians(arccos(a)));
				}
				else {
					if(deg.isSelected())
						input.setText(""+cos(Math.toRadians(a)));
					else
						input.setText(""+cos(a));
				}
			}
		});
		option[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Double.parseDouble(input.getText());
				if(inv.isSelected()) {
					if(deg.isSelected()) {
						if(a == Double.POSITIVE_INFINITY)
							input.setText("90.0");
						else
							input.setText(""+arctan(a));
						}
					else
						if(a == Double.POSITIVE_INFINITY)
							input.setText(""+Math.toRadians(90));
						else
							input.setText(""+Math.toRadians(arctan(a)));
					}
				else {
					if(deg.isSelected())
						input.setText(""+(sin(Math.toRadians(a))/cos(Math.toRadians(a))));
					else
						input.setText(""+(sin(a)/cos(a)));
				}
			}
		});
		option[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Double.parseDouble(input.getText());
				if(inv.isSelected()) {
					if(deg.isSelected()) {
						if(a == Double.POSITIVE_INFINITY)
							input.setText("0.0");
						else {
							if(a == 0) 
								input.setText("90.0");
							else
								input.setText(""+arctan(1/a));
						}
					}
					else
						if(a == Double.POSITIVE_INFINITY)
							input.setText(""+(Math.toRadians(0)));
						else {
							if(a == 0)
								input.setText(""+Math.toRadians(90));
							else
								input.setText(""+(Math.toRadians(arctan(1/a))));
						}
					}
				else {
					if(deg.isSelected())
						input.setText(""+(cos(Math.toRadians(a)/sin(Math.toRadians(a)))));
					else
						input.setText(""+(cos(a)/sin(a)));
				}
			}
		});
		option[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Double.parseDouble(input.getText());
				if(inv.isSelected()) {
					if(deg.isSelected())
						input.setText(""+arccos(1/a));
					else
						input.setText(""+Math.toRadians(arccos(1/a)));
				}
				else {
					if(deg.isSelected())
						input.setText(""+(1/cos(Math.toRadians(a))));
					else
						input.setText(""+(1/cos(a)));
				}
			}
		});
		option[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Double.parseDouble(input.getText());
				if(inv.isSelected()) {
					if(deg.isSelected())
						input.setText(""+arcsin(1/a));
					else
						input.setText(""+Math.toRadians(arcsin(1/a)));
						
				}
				else {
					if(deg.isSelected())
						input.setText(""+(1/sin(Math.toRadians(a))));
					else
						input.setText(""+(1/sin(a)));
				}
			}
		});
		option[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Double.parseDouble(input.getText());
				input.setText("");
				op = 7;
			}
		});
		option[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String z = input.getText();
				String part[] = z.split(" ");
				int b[] = new int[part.length];
				int d = 0;
				while(d < b.length)
					b[d] = Integer.parseInt(part[d++]);
				b = sort(b);
				d = 0;
				input.setText("");
				while(d < b.length)
					input.append(""+b[d++]+" ");
			}
		});
		option[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ans = 0;
				switch(op) {
				case 1 :
					if(com.isSelected()) {
						pb = input.getText().split(" ");
						pa[1] = pa[1].replaceAll("i", "");
						pb[1] = pb[1].replaceAll("i", "");
						Rea = Double.parseDouble(pa[0])+Double.parseDouble(pb[0]);
						Ima = Double.parseDouble(pa[1])+Double.parseDouble(pb[1]);
						if(Rea == 0) {
							if(Ima == 0)
								input.setText("0");
							else
								input.setText(((Ima%1==0)?format.format(Ima):Ima)+"i");
						}
						else {
							if(Ima > 0)
								input.setText((Rea%1==0?format.format(Rea):Rea)+" +"+((Ima%1==0)?format.format(Ima):Ima)+"i");
							else if(Ima == 0)
								input.setText(""+((Rea%1==0)?format.format(Rea):Rea));
							else if(Ima < 0)
								input.setText(((Rea%1==0)?format.format(Rea):Rea)+" "+((Ima%1==0)?format.format(Ima):Ima)+"i");
						}
					}
					else {
						ans = Double.parseDouble(input.getText());
						ans = a+ans;
						ans = Math.round(ans*10000000000.0);
						ans = ans/10000000000.0;
						input.setText(""+ans);
					}
					break;
				case 2 :
					if(com.isSelected()) {
						pb = input.getText().split(" ");
						pa[1] = pa[1].replaceAll("i", "");
						pb[1] = pb[1].replaceAll("i", "");
						Rea = Double.parseDouble(pa[0])-Double.parseDouble(pb[0]);
						Ima = Double.parseDouble(pa[1])-Double.parseDouble(pb[1]);
						if(Rea == 0) {
							if(Ima == 0)
								input.setText("0");
							else
								input.setText(((Ima%1==0)?format.format(Ima):Ima)+"i");
						}
						else {
							if(Ima > 0)
								input.setText((Rea%1==0?format.format(Rea):Rea)+" +"+((Ima%1==0)?format.format(Ima):Ima)+"i");
							else if(Ima == 0)
								input.setText(""+((Rea%1==0)?format.format(Rea):Rea));
							else if(Ima < 0)
								input.setText(((Rea%1==0)?format.format(Rea):Rea)+" "+((Ima%1==0)?format.format(Ima):Ima)+"i");
						}
					}
					else {
						ans = Double.parseDouble(input.getText());
						ans = a-ans;
						ans = Math.round(ans*10000000000.0);
						ans = ans/10000000000.0;
						input.setText(""+ans);
					}
					break;
				case 3 :
					if(com.isSelected()) {
						pb = input.getText().split(" ");
						pa[1] = pa[1].replaceAll("i", "");
						pb[1] = pb[1].replaceAll("i", "");
						Rea = Double.parseDouble(pa[0]);
						Reb = Double.parseDouble(pb[0]);
						Ima = Double.parseDouble(pa[1]);
						Imb = Double.parseDouble(pb[1]);
						par = Math.sqrt(Rea*Rea+Ima*Ima);
						pbr = Math.sqrt(Reb*Reb+Imb*Imb);
						pat = arccos(Rea/par);
						pbt = arccos(Reb/pbr);
						pnr = par*pbr;
						pnt = pat+pbt;
						Ren = pnr*cos(Math.toRadians(pnt));
						Imn = pnr*sin(Math.toRadians(pnt));
						Ren = Math.round(Ren*10000000000.0);
						Ren = Ren/10000000000.0;
						Imn = Math.round(Imn*10000000000.0);
						Imn = Imn/10000000000.0;
						if(Ren == 0) {
							if(Imn == 0)
								input.setText("0");
							else
								input.setText((Imn%1==0)?format.format(Imn):Imn+"i");
						}
						else {
							if(Imn > 0)
								input.setText(((Ren%1==0)?format.format(Ren):Ren)+" +"+((Imn%1==0)?format.format(Imn):Imn)+"i");
							else if(Imn == 0)
								input.setText(""+((Ren%1==0)?format.format(Ren):Ren));
							else if(Imn < 0)
								input.setText(((Ren%1==0)?format.format(Ren):Ren)+" "+((Imn%1==0)?format.format(Imn):Imn)+"i");
						}
					}
					else {
						ans = Double.parseDouble(input.getText());
						ans = a*ans;
						ans = Math.round(ans*10000000000.0);
						ans = ans/10000000000.0;
						input.setText(""+ans);
					}
					break;
				case 4 :
					if(com.isSelected()) {
						pb = input.getText().split(" ");
						pa[1] = pa[1].replaceAll("i", "");
						pb[1] = pb[1].replaceAll("i", "");
						Rea = Double.parseDouble(pa[0]);
						Reb = Double.parseDouble(pb[0]);
						Ima = Double.parseDouble(pa[1]);
						Imb = Double.parseDouble(pb[1]);
						par = Math.sqrt(Rea*Rea+Ima*Ima);
						pbr = Math.sqrt(Reb*Reb+Imb*Imb);
						pat = arccos(Rea/par);
						pbt = arccos(Reb/pbr);
						pnr = par/pbr;
						pnt = pat-pbt;
						Ren = pnr*cos(Math.toRadians(pnt));
						Imn = pnr*sin(Math.toRadians(pnt));
						Ren = Math.round(Ren*10000000000.0);
						Ren = Ren/10000000000.0;
						Imn = Math.round(Imn*10000000000.0);
						Imn = Imn/10000000000.0;
						if(Ren == 0) {
							if(Imn == 0)
								input.setText("0");
							else
								input.setText((Imn%1==0)?format.format(Imn):Imn+"i");
						}
						else {
							if(Imn > 0)
								input.setText(((Ren%1==0)?format.format(Ren):Ren)+" +"+((Imn%1==0)?format.format(Imn):Imn)+"i");
							else if(Imn == 0)
								input.setText(""+((Ren%1==0)?format.format(Ren):Ren));
							else if(Imn < 0)
								input.setText(((Ren%1==0)?format.format(Ren):Ren)+" "+((Imn%1==0)?format.format(Imn):Imn)+"i");
						}
					}
					else {
						ans = Double.parseDouble(input.getText());
						ans = a/ans;
						ans = Math.round(ans*10000000000.0);
						ans = ans/10000000000.0;
						input.setText(""+ans);
					}
					break;
				case 5 :
					if(com.isSelected()) {
						pa[1] = pa[1].replaceAll("i", "");
						double pow = Double.parseDouble(input.getText());
						Rea = Double.parseDouble(pa[0]);
						Ima = Double.parseDouble(pa[1]);
						par = Math.sqrt(Rea*Rea+Ima*Ima);
						pat = arccos(Rea/par);
						pnr = Math.pow(par, 1/pow);
						pnt = pat/pow;
						Ren = pnr*cos(Math.toRadians(pnt));
						Imn = pnr*sin(Math.toRadians(pnt));
						Ren = Math.round(Ren*10000000000.0);
						Ren = Ren/10000000000.0;
						Imn = Math.round(Imn*10000000000.0);
						Imn = Imn/10000000000.0;
						if(Ren == 0) {
							if(Imn == 0)
								input.setText("0");
							else
								input.setText(((Imn%1==0)?format.format(Imn):Imn)+"i");
						}
						else {
							if(Imn > 0)
								input.setText(((Ren%1==0)?format.format(Ren):Ren)+" +"+((Imn%1==0)?format.format(Imn):Imn)+"i");
							else if(Imn == 0)
								input.setText(""+((Ren%1==0)?format.format(Ren):Ren));
							else if(Imn < 0)
								input.setText(((Ren%1==0)?format.format(Ren):Ren)+" "+((Imn%1==0)?format.format(Imn):Imn)+"i");
						}
					}
					else {
						ans = Double.parseDouble(input.getText());
						ans = Math.pow(ans,1/a);
						input.setText(""+ans);
					}
					break;
				case 6 :
					if(com.isSelected()) {
						pa[1] = pa[1].replaceAll("i", "");
						double pow = Double.parseDouble(input.getText());
						Rea = Double.parseDouble(pa[0]);
						Ima = Double.parseDouble(pa[1]);
						par = Math.sqrt(Rea*Rea+Ima*Ima);
						pat = arccos(Rea/par);
						pnr = Math.pow(par, pow);
						pnt = pat*pow;
						Ren = pnr*cos(Math.toRadians(pnt));
						Imn = pnr*sin(Math.toRadians(pnt));
						Ren = Math.round(Ren*10000000000.0);
						Ren = Ren/10000000000.0;
						Imn = Math.round(Imn*10000000000.0);
						Imn = Imn/10000000000.0;
						if(Ren == 0) {
							if(Imn == 0)
								input.setText("0");
							else
								input.setText(((Imn%1==0)?format.format(Imn):Imn)+"i");
						}
						else {
							if(Imn > 0)
								input.setText(((Ren%1==0)?format.format(Ren):Ren)+" +"+((Imn%1==0)?format.format(Imn):Imn)+"i");
							else if(Imn == 0)
								input.setText(""+((Ren%1==0)?format.format(Ren):Ren));
							else if(Imn < 0)
								input.setText(((Ren%1==0)?format.format(Ren):Ren)+" "+((Imn%1==0)?format.format(Imn):Imn)+"i");
						}
					}
					else {
						ans = Double.parseDouble(input.getText());
						ans = Math.pow(a,ans);
						input.setText(""+ans);
					}
					break;
				case 7 :
					ans = Double.parseDouble(input.getText());
					if(inv.isSelected() == false)
						input.setText(""+Math.log10(ans)/Math.log10(a));
					else
						input.setText(""+Math.pow(ans, a));
				}
			}
		});
	}
}
