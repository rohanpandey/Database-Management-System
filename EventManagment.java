import java.awt.*;
import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JFrame implements ActionListener {
    static Connection conn;
    
    int prev=-1;
    int z=0;


    JLabel title=new JLabel("Event Management System");
    JButton login_bt=new JButton("Login");
    JLabel Studentname=new JLabel(" Enter Name   ");
    JTextField enter_student_name=new JTextField();
    JLabel stallName=new JLabel(" Enter Stall Name    ");
    JTextField enter_stall=new JTextField();
    JLabel age=new JLabel(" Enter Age       ");
    JTextField enter_age=new JTextField();
    JLabel college=new JLabel(" Enter College");
    JTextField enter_college=new JTextField();
    JLabel event=new JLabel(" Enter Event    ");
    JTextField enter_event=new JTextField();
    ButtonGroup group=new ButtonGroup();
    JPanel vendor_panel=new JPanel(new GridLayout(6,1));
    JPanel sponsor_panel=new JPanel(new GridLayout(4,1));
    JLabel sponsorName = new JLabel("Enter Sponsor Name  ");
    JTextField enter_sponsor = new JTextField();
    JLabel amount = new JLabel("Enter amount                ");
    JTextField enter_amount = new JTextField();

    JPanel participant_regnow=new JPanel(new FlowLayout());
    JPanel sponsor_regnow=new JPanel(new FlowLayout());
    JPanel vendor_regnow=new JPanel(new FlowLayout());




    JFrame sponsor_frame=new JFrame();
    JLabel display_vendor_name=new JLabel("Vendor name");
    JLabel display_Vendor_company=new JLabel("Company name");
    JLabel display_vendor_nostall=new JLabel("No of stalls");
    JLabel display_vendor_openingtime=new JLabel("Opening time");
    JLabel display_vendor_closingtime=new JLabel("Closing time");
    JButton vendor_alter=new JButton("ALTER");
    JButton vendor_delete=new JButton("DELETE");
    JLabel opening_time_label=new JLabel("Alter opening time");
    JLabel closing_time_label=new JLabel("Alter closing time");
    JLabel nostalls_label=new JLabel("Alter number of stalls");
    JTextField opening_time_field=new JTextField();
    JTextField closing_time_field=new JTextField();
    JTextField nostalls_field=new JTextField();
    JLabel enter_no_of_stalls=new JLabel("Enter the number of stalls");
    JTextField enter_no_of_stalls_field=new JTextField();
    JLabel enter_openingtime=new JLabel("Enter the opening time");
    JLabel enter_closingtime=new JLabel("Enter the closing time");
    JTextField enter_openingtime_field=new JTextField();
    JTextField enter_closingtime_field=new JTextField();
    JLabel enter_vendor_company=new JLabel("Enter the name of the company");
    JTextField enter_vendor_company_field=new JTextField();
    
    


    JLabel login=new JLabel("Login");
    JLabel username=new JLabel("Username");
    JTextField username_field=new JTextField();
    JTextField password_field=new JTextField();

    JLabel password=new JLabel("Password");
    JLabel register=new JLabel("New User? Register Below.");
    JButton reg_bt=new JButton("Register");
    JPanel panel=new JPanel(new FlowLayout());

    JPanel panel1=new JPanel(new FlowLayout());
    JPanel panel2=new JPanel(new FlowLayout());
    JPanel panel3=new JPanel(new FlowLayout());
    JPanel panel4=new JPanel(new FlowLayout());
    JPanel panel5=new JPanel(new FlowLayout());
    JPanel panel9=new JPanel(new FlowLayout());


    JFrame register_frame=new JFrame();
    JFrame participant_frame=new JFrame();

    JFrame vendor_frame=new JFrame();


    JLabel display_participant_name=new JLabel("Name");
    JLabel display_participant_age=new JLabel("Age");
    JLabel display_participant_college=new JLabel("College");
    JLabel display_participant_event=new JLabel("Event");



    JButton participant_new=new JButton("New");
    JButton participant_search=new JButton("Search");
    JButton participant_delete=new JButton("Delete");
    Choice  participant_choice=new Choice();


    JButton participant_confirm=new JButton("Confirm");


    JLabel display_sponsor_name=new JLabel("Name");
    JLabel display_sponsor_company=new JLabel("Company");
    JLabel display_sponsor_amount=new JLabel("Amount");
    JTextField alter_amount_field=new JTextField();
    JButton sponsor_alter=new JButton("Alter amount");
    JButton sponsor_delete=new JButton("Delete");
    JLabel sponsor_amount_label=new JLabel("Alter the amount");


    JLabel register_label = new JLabel("Register Your Account");
    JLabel enter_username=new JLabel("Set Username");
    JLabel enter_password=new JLabel("Set Password");
    JTextField enter_ufield=new JTextField();
    JTextField enter_pfield=new JTextField();
    JComboBox type=new JComboBox();

    JButton participant_regButton=new JButton("Register Now");
    JButton sponsor_regButton=new JButton("Register Now");
    JButton vendor_regButton=new JButton("Register Now");


    JPanel temp=new JPanel();
    JCheckBox vendor=new JCheckBox("vendor");
    JCheckBox participant=new JCheckBox("participant");
    JCheckBox sponsor=new JCheckBox("sponsor");
    JLabel vendorName=new JLabel("  Enter Name             ");
    JTextField enter_vendor_name=new JTextField();
    JPanel participant_choice_panel=new JPanel(new FlowLayout());


    public Main() throws SQLException
    {
        
         conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/eventmanagementsystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "root", "passwdis0");   // For MySQL
              
 
         Statement stmt = conn.createStatement();
       
             System.out.println("the connection works");
             
             String query="select * from events";
             ResultSet set=stmt.executeQuery(query);
             while(set.next())
             {
                 String name=set.getString("name");
                 participant_choice.addItem(name);
                 
             }
             
             
        participant_regnow.add(participant_regButton);
        vendor_regnow.add(vendor_regButton);
        sponsor_regnow.add(sponsor_regButton);
        


        vendor_frame.setVisible(false);
        vendor_frame.setLayout(new GridLayout(7,1));
        vendor_frame.setSize(800,800);
        sponsor_frame.setVisible(false);
        sponsor_frame.setLayout(new GridLayout(5,1));
        sponsor_frame.setSize(800,800);

        participant_frame.setSize(800,800);

        participant_frame.setLayout(new GridLayout(6,1));
        participant_frame.add(new JPanel(new FlowLayout()).add(display_participant_name));
        participant_frame.add(new JPanel(new FlowLayout()).add(display_participant_age));
        participant_frame.add(new JPanel(new FlowLayout()).add(display_participant_college));
        participant_frame.add(new JPanel(new FlowLayout()).add(display_participant_event));
        JPanel participant_button_panel=new JPanel(new FlowLayout());
        participant_button_panel.add(participant_new);
        participant_button_panel.add(participant_search);
        participant_button_panel.add(participant_delete);
        participant_choice_panel.add(participant_choice);
        participant_frame.add(participant_choice_panel);

        participant_frame.add(participant_button_panel);
        participant_frame.setVisible(false);


        sponsor_frame.add(new JPanel(new FlowLayout()).add(display_sponsor_name));
        sponsor_frame.add(new JPanel(new FlowLayout()).add(display_sponsor_company));
        sponsor_frame.add(new JPanel(new FlowLayout()).add(display_sponsor_amount));
        JPanel sponsor_choice_panel=new JPanel(new FlowLayout());
        alter_amount_field.setPreferredSize(new Dimension(200,30));
        sponsor_choice_panel.add(sponsor_amount_label);
        sponsor_choice_panel.add(alter_amount_field);
        sponsor_choice_panel.add(sponsor_alter);
        sponsor_frame.add(sponsor_choice_panel);
        sponsor_delete.setPreferredSize(new Dimension(100,30));
        JPanel temp_use=new JPanel(new FlowLayout()) ;
        temp_use.add(sponsor_delete);
        sponsor_frame.add(new JPanel(new FlowLayout()).add(temp_use));


        vendor_frame.add(new JPanel(new FlowLayout()).add(display_vendor_name));
        vendor_frame.add(new JPanel(new FlowLayout()).add(display_sponsor_company));
        vendor_frame.add(new JPanel(new FlowLayout()).add(display_vendor_nostall));
        vendor_frame.add(new JPanel(new FlowLayout()).add(display_vendor_openingtime));
        vendor_frame.add(new JPanel(new FlowLayout()).add(display_vendor_closingtime));
        JPanel vendor_choice_panel=new JPanel(new FlowLayout());
        vendor_choice_panel.add(nostalls_label);
        nostalls_field.setPreferredSize(new Dimension(100,30));
        vendor_choice_panel.add(nostalls_field);
        vendor_choice_panel.add(opening_time_label);
        opening_time_field.setPreferredSize(new Dimension(100,30));
        vendor_choice_panel.add(opening_time_field);
        vendor_choice_panel.add(closing_time_label);
        closing_time_field.setPreferredSize(new Dimension(100,30));
        vendor_choice_panel.add(closing_time_field);
        vendor_choice_panel.add(vendor_alter);
        JPanel tempuse2=new JPanel();
        tempuse2.add(vendor_delete);
        vendor_frame.add(vendor_choice_panel);
        vendor_frame.add(new JPanel(new FlowLayout()).add(tempuse2));

        temp.setLayout(new GridLayout(5,1));

        this.setBackground(Color.GREEN);
        //register_frame.setSize(1920,1000);
        register_frame.setVisible(false);
        register_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        group.add(vendor);
        group.add(participant);
        group.add(sponsor);


        this.setLayout(new GridLayout(7,1));
        register_frame.setLayout(new GridLayout(4,1));

        title.setFont(new Font("serif",Font.PLAIN,60));

        username_field.setPreferredSize(new Dimension(200,30));
        password_field.setPreferredSize(new Dimension(200,30));
        login.setFont(new Font("serif",Font.PLAIN,30));
        register.setFont(new Font("serif",Font.PLAIN,30));
        username.setFont(new Font("serif",Font.PLAIN,20));
        password.setFont(new Font("serif",Font.PLAIN,20));
        reg_bt.setPreferredSize(new Dimension(100,50));
        reg_bt.setFont(new Font("serif",Font.PLAIN,20));
        login_bt.setPreferredSize(new Dimension(100,50));
        login_bt.setFont(new Font("serif",Font.PLAIN,20));
        enter_student_name.setPreferredSize(new Dimension(200,30));
        enter_college.setPreferredSize(new Dimension(200,30));
        enter_age.setPreferredSize(new Dimension(200,30));
        enter_event.setPreferredSize(new Dimension(200,30));
        enter_vendor_name.setPreferredSize(new Dimension(200,30));
        enter_stall.setPreferredSize(new Dimension(200,30));
        enter_sponsor.setPreferredSize(new Dimension(200,30));
        enter_amount.setPreferredSize(new Dimension(200,30));

        Color clr1 = new Color(127, 173, 187);
        panel1.setBackground(clr1);
        panel2.setBackground(clr1);
        panel3.setBackground(clr1);
        panel4.setBackground(clr1);
        panel5.setBackground(clr1);
        panel.setBackground(clr1);
        panel9.setBackground(clr1);
        panel.setBorder(BorderFactory.createEtchedBorder((EtchedBorder.RAISED)));

        panel.add(title);
        panel1.add(login);

        panel2.add(username);
        panel2.add(username_field);
        panel3.add(password);
        panel3.add(password_field);
        panel4.add(register);
        panel5.add(reg_bt);
        panel9.add(login_bt);



        this.add(panel);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel9);

        this.add(panel4);
        this.add(panel5);
        
        vendor_regButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                 try {
                     Statement stmt=conn.createStatement();
                     String username=enter_ufield.getText();
                     String password=enter_pfield.getText();
                     
                     
                    String query="insert into user values("+"'"+username+"'"+","+"'"+password+"'"+","+"'"+"vendor"+"')";
                     System.out.println(query);
                     
                    
                     int count=stmt.executeUpdate(query);
                     System.out.println(count);
                 } catch (SQLException ex) {
                     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }
         });
       participant_regButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                  try {
                     Statement stmt=conn.createStatement();
                     String username=enter_ufield.getText();
                     String password=enter_pfield.getText();
                     
                     
                    String query="insert into user values("+"'"+username+"'"+","+"'"+password+"'"+","+"'"+"participant"+"')";
                     System.out.println(query);
                     
                    
                     int count=stmt.executeUpdate(query);
                     System.out.println(count);
                     String name=enter_student_name.getText();
                     String college=enter_college.getText();
                     int age=Integer.parseInt(enter_age.getText());
                     String events=enter_event.getText();
                     
                     String query1="insert into participant values("+"'"+name+"'"+","+age+","+"'"+college+"'"+","+"'"+events+"'"+","+"'"+username+"'"+","+"'"+password+"')";
                     
                      System.out.println(query1);
                      
                     Statement stmt2=conn.createStatement();
                     int count1=stmt2.executeUpdate(query1);
                     
                     
              
                 } catch (SQLException ex) {
                     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
             }
         });
       
       
       
       
       sponsor_regButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                  try {
                     Statement stmt=conn.createStatement();
                     String username=enter_ufield.getText();
                     String password=enter_pfield.getText();
                     
                     
                    String query="insert into user values("+"'"+username+"'"+","+"'"+password+"'"+","+"'"+"sponsor"+"')";
                     System.out.println(query);
                     
                    
                     int count=stmt.executeUpdate(query);
                     System.out.println(count);
                 } catch (SQLException ex) {
                     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         });


        login_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String username=username_field.getText();
                    String password=password_field.getText();
                    Statement stmt=conn.createStatement();
                    String type="";
                    
                    
                    int temp=0;
                    String query="select * from user";
                    ResultSet set=stmt.executeQuery(query);
                    while(set.next())
                    {
                        String uname=set.getString("username");
                        String pname=set.getString("password");
                        if(username.equals(uname)==true && password.equals(pname)==true)
                                {
                                    type=type+set.getString("type");
                                    break;
                                    
                                    
                                }
                        
                        
                    }
                    Statement stmt2=conn.createStatement();
                    String query1="select * from "+type;
                    System.out.println(query1);
                    
                    ResultSet set1=stmt2.executeQuery(query1);
                    while(set1.next())
                    {  
                        if(type.equals("participant"))
                        {
                        if(set1.getString("username").equals(username)==true && set1.getString("password").equals(password)==true)
                        {
                            display_participant_name.setText("Name:   "+set1.getString("name"));
                            display_participant_age.setText("Age:   "+set1.getInt("age")+"");
                            display_participant_college.setText("College:  "+set1.getString("college"));
                            display_participant_event.setText("Events:   "+set1.getString("events"));
                            
                            
                        }
                        }
                        if(type.equals("vendor"))
                        {
                            
                          
                        }
                    }
                    
                    
                    
                    
                    if(type.equals("partcipant")==true)
                        z=0;
                     if(type.equals("vendor")==true)
                        z=2;
                      if(type.equals("sponsor")==true)
                        z=1;
                    
                    
                    
                    if(z==0)
                        participant_frame.setVisible(true);
                    if(z==1)
                        sponsor_frame.setVisible(true);
                    if(z==2)
                        vendor_frame.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        reg_bt.addActionListener(this);
        vendor.addActionListener(this);
        participant.addActionListener(this);
        sponsor.addActionListener(this);
        participant_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


            }
        });
        participant_delete.addActionListener(this);
        participant_search.addActionListener(this);

        enter_ufield.setPreferredSize(new Dimension(200,30));
        enter_pfield.setPreferredSize(new Dimension(200,30));

        JPanel register_label1 = new JPanel(new GridLayout(3,1));
        JPanel panel6=new JPanel(new FlowLayout());
        JPanel panel7=new JPanel(new FlowLayout());
        JPanel panel8=new JPanel(new FlowLayout());

        type.addItem("vendor");
        type.addItem("sponsor");

        type.setPreferredSize(new Dimension(200,100));
        register_label.setForeground(Color.GRAY);
        register_label.setFont(new Font("Courier New", Font.ITALIC, 40));
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(register_label);
        register_label1.add(new JPanel(new FlowLayout()));
        register_label1.add(p1);
        register_label1.add(new JPanel(new FlowLayout()));
        register_label1.setBorder(BorderFactory.createEtchedBorder((EtchedBorder.RAISED)));
        JPanel enter_values = new JPanel(new GridLayout(4,1));
        panel6.add(enter_username);
        panel6.add(enter_ufield);
        panel7.add(enter_password);
        panel7.add(enter_pfield);
        enter_values.add(new JPanel());
        enter_values.add(panel6);
        enter_values.add(panel7);
        enter_values.add(new JPanel());
        JPanel type = new JPanel(new GridLayout(3,1));
        type.add(new JPanel());
        panel8.add(vendor);
        panel8.add(participant);
        panel8.add(sponsor);
        type.add(panel8);
        type.add(new JPanel());

        register_frame.add(register_label1);
        register_frame.add(enter_values);
        //register_frame.add(panel7);
        register_frame.add(type);

        JPanel temp10=new JPanel(new FlowLayout());
        JPanel temp11=new JPanel(new FlowLayout());
        JPanel temp12=new JPanel(new FlowLayout());
        JPanel temp13=new JPanel(new FlowLayout());
        temp10.add(Studentname);
        temp10.add(enter_student_name);
        temp11.add(age);
        temp11.add(enter_age);
        temp12.add(college);
        temp12.add(enter_college);
        temp13.add(event);
        temp13.add(enter_event);
        temp.add(temp10);
        temp.add(temp11);
        temp.add(temp12);
        temp.add(temp13);
        temp.add(new JPanel(new FlowLayout()).add(participant_regnow));



        JPanel temp14=new JPanel(new FlowLayout());
        JPanel temp15=new JPanel(new FlowLayout());
        temp14.add(vendorName);
        temp14.add(enter_vendor_name);
        temp15.add(stallName);
        temp15.add(enter_stall);
        JPanel temp16=new JPanel(new FlowLayout());
        enter_no_of_stalls_field.setPreferredSize(new Dimension(200,30));
        enter_closingtime_field.setPreferredSize(new Dimension(200, 30));
        enter_openingtime_field.setPreferredSize(new Dimension(200,30));
        
        temp16.add(enter_no_of_stalls);
        temp16.add(enter_no_of_stalls_field);
                JPanel temp17=new JPanel(new FlowLayout());
                        JPanel temp18=new JPanel(new FlowLayout());
         temp17.add(enter_closingtime);
         temp17.add(enter_closingtime_field);
         temp18.add(enter_openingtime);
         temp18.add(enter_openingtime_field);
         


           
        
        vendor_panel.add(temp14);
        vendor_panel.add(temp15);
                vendor_panel.add(temp16);
                        vendor_panel.add(temp17);
        vendor_panel.add(temp18);

        
        vendor_panel.add(new JPanel(new FlowLayout()).add(vendor_regnow));
        



        JPanel panel16=new JPanel(new FlowLayout());
        JPanel panel17=new JPanel(new FlowLayout());

        panel16.add(sponsorName);
        panel16.add(enter_sponsor);
        panel17.add(amount);
        panel17.add(enter_amount);
        sponsor_panel.add(panel16);
        sponsor_panel.add(panel17);
        sponsor_panel.add(new JPanel(new FlowLayout()).add(sponsor_regnow));


    }

    public static void main(String[] args) throws SQLException
    {
        
        
      
          conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/eventmanagementsystem?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "root", "passwdis0");   // For MySQL
              
 
         Statement stmt = conn.createStatement();
       
             System.out.println("the connection works");
             
           
      


        Main ob=new Main();
        ob.setVisible(true);
        ob.setSize(800,800);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getActionCommand().equals("Register"))
        {
            register_frame.setVisible(true);
            


        }
        
        
        
        if(e.getActionCommand().equals("vendor"))
        {

            if(prev==1)
                register_frame.remove(temp);
            if(prev==2)
                register_frame.remove(sponsor_panel);

            repaint();


            System.out.println(e.getActionCommand());
            register_frame.add(vendor_panel);
            register_frame.revalidate();
            register_frame.repaint();
            pack();
            prev=0;

        }
        if(e.getActionCommand().equals("participant") )
        {   repaint();


            if(prev==0)
                register_frame.remove(vendor_panel);
            if(prev==2)
                register_frame.remove(sponsor_panel);

            repaint();


            System.out.println(e.getActionCommand());
            register_frame.add(temp);
            register_frame.revalidate();
            register_frame.repaint();
            pack();
            prev=1;

        }

        if(e.getActionCommand().equals("sponsor"))
        {

            repaint();


            if(prev==0)
                register_frame.remove(vendor_panel);
            if(prev==1)
                register_frame.remove(temp);

            repaint();


            System.out.println(e.getActionCommand());
            register_frame.add(sponsor_panel);
            register_frame.revalidate();
            register_frame.repaint();
            pack();
            prev=2;

        }
        if(e.getActionCommand().equals(login))
        {

            if(z==0)
            {

                participant_frame.setVisible(true);


            
            }
        }

    }
}
