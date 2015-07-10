package com.cn.choujiang;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GoodLucky extends JFrame implements ActionListener {
	JTextField tf = new JTextField();
	public static final int KEY_B= 66;  //B
	public static final int KEY_S = 83;//S
	public static final int KEY_T = 84; //T

	JLabel lstart = new JLabel();
	JLabel lstop = new JLabel();
	JLabel lt = new JLabel();
	boolean isGo = false;
	JLabel num = new JLabel("000");
	JPanel imagePanel;
	ImageIcon background;
	
	static Integer periodStart = 0;
	static Integer periodEnd = 0;
	
	private List<Integer> list = new ArrayList<Integer>();//用于存储获取的号码
	
	private List<Integer> usedNums = new ArrayList<Integer>();//用于存储获取的号码	
	
	static LuckyNum luck1 = new LuckyNum();
	static LuckyNum luck2 = new LuckyNum();
	static LuckyNum luck3 = new LuckyNum();
	//static LuckyNum luck4 = new LuckyNum();
	//int count = 0;
	static Properties prop;
	
	JPanel pnum = new JPanel();//显示获奖名单;
	
	//读取配置文件
	static {   
		prop = new Properties();   
		try {
            prop.load(new InputStreamReader(GoodLucky.class.getClass().getResourceAsStream("/source/config.properties"),"utf-8"));   

            String period = prop.getProperty("period");
            periodStart = Integer.parseInt(period.substring(0, period.indexOf("-")));
            periodEnd = Integer.parseInt(period.substring(period.indexOf("-")+1));
            
            setLukyNum(1);
			setLukyNum(2);
			setLukyNum(3);
			//setLukyNum(4);
            
        } catch (IOException e) {   
            e.printStackTrace();   
        }
    }   
	
	///将奖项封装成对象
	private static void setLukyNum(int n){
		LuckyNum ln = new LuckyNum();
		String temp = "l"+n;
		String l = prop.getProperty(temp);
		
		
		String[] s1 = l.split("#");
		
		String[] s11 = s1[0].split(",");
		for(String s:s11){
			ln.getPeriodList().add(Integer.parseInt(s));
		}
		
		String[] s12 = s1[1].split(",");
		ln.setStart(Integer.parseInt(s12[0]));
		ln.setEnd(Integer.parseInt(s12[1]));
		
		String[] s13 = s1[2].split(",");
		for(String s:s13){
			ln.getNums().add(Integer.parseInt(s));
		}
		
		String[] s14 = s1[3].split(",");
		for(String s:s14){
			ln.setLevel(s);
		}
		
		String[] s15 = s1[4].split(",");
		for(String s:s15){
			ln.setName(s);
		}
		

		if(n==1){
			luck1 = ln;
			//System.out.println("l1:" + luck1.toString());
		}else if(n==2){
			luck2 = ln;
			//System.out.println("l2:" + luck2.toString());
		}else if(n==3){
			luck3 = ln;
			//System.out.println("l3:" + luck3.toString());
		}
	}
	
	//构建主页面
	public GoodLucky() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();  
		double screenWidth = dim.getWidth();
		double screenHeight = dim.getHeight();
		this.setSize((int)screenWidth, (int)screenHeight);
		
		String backimgUrlString = "";
		String startimgUrlString = "";
		String stopimgUrlString = "";
//根据屏幕分辨率来设置不同的背景		
		if(screenWidth == 800){
			num.setBounds(410, 280, 300, 110);
			pnum.setBounds(30, 110, 200, 450);
			lstart.setBounds(322, 440, 190,57);
			lstop.setBounds(550, 440, 190, 57);
			backimgUrlString = "/source/800.png";
			startimgUrlString = "/source/800-1.png";
			stopimgUrlString = "/source/800-2.png";
		}else if(screenWidth == 1024){
			num.setBounds(520, 390, 300, 110);
			pnum.setBounds(40, 180, 200, 450);
			lstart.setBounds(420, 600, 225,60);
			lstop.setBounds(660, 600, 225, 60);
			backimgUrlString = "/source/1024.png";
			startimgUrlString = "/source/1024-1.png";
			stopimgUrlString = "/source/1024-2.png";
		}else if(screenWidth == 1280){
			num.setBounds(630, 420, 300, 110);
			pnum.setBounds(40, 150, 200, 450);
			lstart.setBounds(500, 600, 250,68);
			lstop.setBounds(800, 600, 250, 68);
			backimgUrlString = "/source/1280.png";
			startimgUrlString = "/source/1280-1.png";
			stopimgUrlString = "/source/1280-2.png";
		}else if(screenWidth == 1440){
			num.setBounds(800, 520, 300, 110);
			pnum.setBounds(50, 150, 200, 450);
			lstart.setBounds(600, 720, 295,80);
			lstop.setBounds(950, 720, 295, 80);
			backimgUrlString = "/source/1440.png";
			startimgUrlString = "/source/1440-1.png";
			stopimgUrlString = "/source/1440-2.png";
		}else{
			num.setBounds(520, 390, 300, 110);
			pnum.setBounds(40, 180, 200, 450);
			lstart.setBounds(420, 600, 225,60);
			lstop.setBounds(660, 600, 225, 60);
			backimgUrlString = "/source/1024.png";
			startimgUrlString = "/source/1024-1.png";
			stopimgUrlString = "/source/1024-2.png";
			this.setSize(1024, 768);
		}
		

		ImageIcon img = new ImageIcon(GoodLucky.class.getResource(backimgUrlString));//这是背景图片   
	    //img.setImage(img.getImage().getScaledInstance(img.getIconWidth(), img.getIconHeight(), Image.SCALE_DEFAULT));
		JLabel imgLabel = new JLabel(img);//将背景图放在标签里。   
	   
	    this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的     LayeredPane面板里。   
	    imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//设置背景标签的位置   
	    Container cp=this.getContentPane();   
	    cp.setLayout(null);      //这里选择绝对布局管理器，对于边界布局管理器，放入控件后，无法显示背景图片；因为将整个面板都填充满了；
	    ((JPanel)cp).setOpaque(false); //这样就能显示出背景图片出来了。
		//b1.setActionCommand("reset");
    	//b1.addActionListener(this);
	    
//键盘监听事件
	    Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			
			@Override
			public void eventDispatched(AWTEvent event) {
				if(((KeyEvent)event).getID() == KeyEvent.KEY_PRESSED){
					
					int code = ((KeyEvent)event).getKeyCode();
					//System.out.println(code);
					if (code==KEY_T) {
						//使用特殊号
						special();
					}else if(code == KEY_B){
						//运行
						start();
					}else if(code == KEY_S){
						//停止
						stop();
					}else if(code == 82){
						//重新开始
						reset();
					}else if(code == 8){
						//回退
						back();
					}
				}
				
			}

		}, AWTEvent.KEY_EVENT_MASK);
//开始按钮	    
	    lstart.addMouseListener(new MouseAdapter() {
	    	
			@Override
			public void mouseClicked(MouseEvent e) {
				start();
			}
		});
//结束按钮
	    lstop.addMouseListener(new MouseAdapter() {
	    	@Override
			public void mouseClicked(MouseEvent e) {
				stop();
			}
		});
	    
	    
		num.setFont(new Font("黑体", Font.BOLD,150));
		num.setForeground(Color.red);
		
		pnum.setBackground(Color.white);
		

		//JPanel ptitle = new JPanel();
		//ptitle.setBounds(60, 120, 120, 40);
		//ptitle.setBackground(Color.white);
		
		
		
		lstart.setName("start");
		
		ImageIcon icon = new ImageIcon(GoodLucky.class.getResource(startimgUrlString));  
        icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),  
                icon.getIconHeight(), Image.SCALE_DEFAULT));
		lstart.setIcon(icon);
		ImageIcon icon2 = new ImageIcon(GoodLucky.class.getResource(stopimgUrlString));  
        icon2.setImage(icon2.getImage().getScaledInstance(icon2.getIconWidth(),  
                icon2.getIconHeight(), Image.SCALE_DEFAULT));
		lstop.setIcon(icon2);
		lstop.setName("stop");
		this.getContentPane().add(pnum);
		this.getContentPane().add(lstart);
		this.getContentPane().add(lstop);
		//this.getContentPane().add(ptitle);
		
		
		this.getContentPane().add(num);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(img.getIconWidth()+5, img.getIconHeight()+10);//抽奖区大小
		this.setTitle("抽奖平台");
		this.setResizable(false);
//		this.setLocation(300, 300);
		
		this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2); 
		Cursor cu = new Cursor(Cursor.HAND_CURSOR);
		this.setCursor(cu);
		this.setVisible(true);
		this.go();
	}
	
	
	
	/**
	 * 数字滚动
	 * 
	 * @author MoWenqiong
	 */
	private void go() {
		while (true) {
			if (isGo == true) {
				boolean flag = true;
				Integer n = -1;
				while (flag) {
					n = (int)((Math.random() * (periodEnd-periodStart))  + periodStart);
					if(!list.contains(n)){
						flag = false;
					}
				}
				
				String i =""+n;

				if (i.length()==1) {
					i = "00"+i;
				}
				if (i.length()==2) {
					i= "0"+i;
				}
				num.setText(i);
				
			}
			try {
				Thread.sleep(10);
			} catch (java.lang.InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 开始运行
	 * 
	 * @author MoWenqiong
	 */
	private  void  start(){
		
		//count++;
		
		int count = this.list.size() + 1;
		if (luck1.getPeriodList().contains(count)) {
			periodStart = luck1.getStart();
			periodEnd = luck1.getEnd();
			isGo = true;
		}else if (luck2.getPeriodList().contains(count)) {
			periodStart = luck2.getStart();
			periodEnd = luck2.getEnd();
			isGo = true;
		}else if (luck3.getPeriodList().contains(count)) {
			periodStart = luck3.getStart();
			periodEnd = luck3.getEnd();
			isGo = true;
		}else{
			//this.setTitle("抽奖已经结束");
			num.setText("end");
		}
	}
	
	/**
	 * 
	 * 结束运行
	 * @author MoWenqiong
	 */
	private  void stop(){
		if (isGo) {
			isGo = false;
			Integer i = Integer.parseInt(num.getText());
			//如果重复了，则继续运行0.1秒后再停止
			if (usedNums.contains(i)) {
				isGo = true;
				try {
					Thread.sleep(100);
					stop();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			list.add(i);
			usedNums.add(i);
			showLucky();
		}
		
	}
	
	/**
	 * 设置为指定的幸运号
	 * 
	 * @author MoWenqiong
	 */
	private void special(){
		if (isGo) {
			isGo = false;
			//判断count所在的区间，根据区间来确定所在的奖项，并从对应的奖项中获取一个特殊号码
			List p1 = luck1.getPeriodList();
			List p2 = luck2.getPeriodList();
			List p3 = luck3.getPeriodList();
			Integer specialNum = -1;
			int count = this.list.size() + 1;
			if(p1.contains(count)){
				for (int i = 0; i < luck1.getNums().size(); i++) {
					if(!usedNums.contains(luck1.getNums().get(i))){
						specialNum = luck1.getNums().get(i);
						break;
					}
				}
				if (specialNum == -1) {
					//如果特殊号码用完，则继续滚动
					isGo = true;
				}
				
			}else if(p2.contains(count)){
				for (int i = 0; i < luck2.getNums().size(); i++) {
					if(!usedNums.contains(luck2.getNums().get(i))){
						specialNum = luck2.getNums().get(i);
						break;
					}
				}
				if (specialNum == -1) {
					//如果特殊号码用完，则继续滚动
					isGo = true;
				}
			}else if (p3.contains(count)) {
				for (int i = 0; i < luck3.getNums().size(); i++) {
					if(!usedNums.contains(luck3.getNums().get(i))){
						specialNum = luck3.getNums().get(i);
						break;
					}
				}
				if (specialNum == -1) {
					//如果特殊号码用完，则继续滚动
					isGo = true;
				}
			}

			if (specialNum != -1) {
				usedNums.add(specialNum);
				list.add(specialNum);
				showLucky();
				String temp = ""+specialNum;
				if(temp.length() == 1){
					num.setText("00"+temp);
				}else if(temp.length() == 2){
					num.setText("0"+temp);
				}else{
					num.setText(temp);
				}
				
			}
		}
	}
	
	private void reset() {
		pnum.removeAll();
		pnum.repaint();
		list.clear();
		usedNums.clear();
		isGo = false;
		//count = 0;
		num.setText("000");
	}
	
	/**
	 * 重获奖名单中删除最新的一个号码
	 * 
	 * @author MoWenqiong
	 */
	private void back(){
		if (list.size()>0) {
			Integer i = list.get(list.size()-1);//删除最后一个数
			//System.out.println("删除数："+i);
			list.remove(i);
			usedNums.remove(i);

			showLucky();
			isGo = false;
			//count--;
			num.setText("000");
		}
	}
	
	/**
	 * 显示幸运号码
	 * 1.根据设置的顺序和每一级别的个数来判断当前的号码放在哪个奖品区
	 * @author MoWenqiong
	 */
	private void showLucky(){

		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int n = list.get(i);
			if (luck1.getPeriodList().contains(i+1)) {
				if (luck1.getLevel().equals("1")) {
					list1.add(n);
				}else if (luck1.getLevel().equals("2")) {
					list2.add(n);
				}else if (luck1.getLevel().equals("3")) {
					list3.add(n);
				}
			}
			if (luck2.getPeriodList().contains(i+1)) {
				if (luck2.getLevel() == "1") {
					list1.add(n);
				}else if (luck2.getLevel().equals("2")) {
					list2.add(n);
				}else if (luck2.getLevel().equals("3")) {
					list3.add(n);
				}
			}
			if (luck3.getPeriodList().contains(i+1)) {
				if (luck3.getLevel().equals("1")) {
					list1.add(n);
				}else if (luck3.getLevel().equals("2")) {
					list2.add(n);
				}else if (luck3.getLevel().equals("3")) {
					list3.add(n);
				}
			}
		}

		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		if(luck1.getLevel().equals("1")){
			s1 = luck1.getName();
		}else if (luck1.getLevel().equals("2")) {
			s2 = luck1.getName();
		}else if (luck1.getLevel().equals("3")) {
			s3 = luck1.getName();
		}else if (luck1.getLevel().equals("4")) {
			s4 = luck1.getName();
		}
		
		if(luck2.getLevel().equals("1")){
			s1 = luck2.getName();
		}else if (luck2.getLevel().equals("2")) {
			s2 = luck2.getName();
		}else if (luck2.getLevel().equals("3")) {
			s3 = luck2.getName();
		}else if (luck2.getLevel().equals("4")) {
			s4 = luck2.getName();
		}
		
		if(luck3.getLevel().equals("1")){
			s1 = luck3.getName();
		}else if (luck3.getLevel().equals("2")) {
			s2 = luck3.getName();
		}else if (luck3.getLevel().equals("3")) {
			s3 = luck3.getName();
		}else if (luck3.getLevel().equals("4")) {
			s4 = luck3.getName();
		}
		
		
		//根据将的级别和奖项个数定位显示的label
		String result = "<html><body style='color:red;'><div style='width:155px;'></div>";
		if (list1.size()>0) {
			result += "<h1>"+s1+"</h1><p>";
			for (int i=0;i<list1.size();i++ ) {
				Integer integer = list1.get(i);
				result += "<span style='font-size:17px;'>" + trans(integer) + "</span>"  + "　";
				if((i+1)%4 == 0){
					result += "<br>";
				}
			}
			result += "<br>";
		}
		if (list2.size()>0) {
			result += "<h1>"+s2+"</h1><p>";
			for (int i=0;i<list2.size();i++ ) {
				Integer integer = list2.get(i);
				result += "<span style='font-size:17px;'>" + trans(integer)+ "</span>" + "　";
				if((i+1)%4 == 0){
					result += "<br>";
				}
			}
			result += "<br>";
		}
		if (list3.size()>0) {
			result += "<h1>"+s3+"</h1><p>";
			for (int i=0;i<list3.size();i++ ) {
				Integer integer = list3.get(i);
				result +="<span style='font-size:17px;'>" +  trans(integer) + "</span>" + "　";
				if((i+1)%4 == 0){
					result += "<br>";
				}
			}
			result += "<br>";
		}

		result += "</body></html>";
		JLabel resultlJLabel = new JLabel();
		resultlJLabel.setSize(200, 400);
		
		pnum.removeAll();
		pnum.add(resultlJLabel);
		resultlJLabel.setText(result);
		
	}

	private String trans(int i){
		if(i<10){
			return "00" + i;
		}else if(i>=10&&i<=99){
			return "0" + i;
		}else{
			return "" + i;
		}
	}
	
	public static void main(String[] args) {
		new GoodLucky();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}