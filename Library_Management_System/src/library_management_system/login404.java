
package library_management_system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class login404 extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
    int i=999;
    
    static String name;
    static String type;
    
    Date date;
    DateFormat format=new SimpleDateFormat("MM/dd/YYYY");
    DateFormat format1=new SimpleDateFormat("hh:mm");
    
    public login404() {
        initComponents();
        setLocationRelativeTo(null);
        setTransparent();
        setHideTxt(false);
    }

    void setTransparent(){
        setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
    }
    
    void setHideTxt(Boolean txt){
        last.setVisible(txt);
        middle.setVisible(txt);
        first.setVisible(txt);
        age.setVisible(txt);
        address.setVisible(txt);
        number.setVisible(txt);
        email.setVisible(txt);
        position.setVisible(txt);
        user.setVisible(txt);
        pass.setVisible(txt);
        conpass.setVisible(txt);
        gender.setVisible(txt);
    }
    
    void setSignUpForm(Boolean signup){
        last.setFocusable(signup);
        first.setFocusable(signup);
        middle.setFocusable(signup);
        age.setFocusable(signup);
        address.setFocusable(signup);
        number.setFocusable(signup);
        email.setFocusable(signup);
        position.setFocusable(signup);
        user.setFocusable(signup);
        pass.setFocusable(signup);
        conpass.setFocusable(signup);
        gender.setFocusable(signup);
    }
    
    void setLoginForm(Boolean login){
        username.setFocusable(login);
        password.setFocusable(login);
    }
    
    void setMovePanel(){
        register.setVisible(false);

        new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    for(int i=0; i<=6; i++){
                        Thread.sleep(130);
                        if(i==1){
                            Thread.sleep(20);
                            cover.setBounds(295,30,350,410);
                            setLoginForm(false);
                        }
                        if(i==2){
                            Thread.sleep(20);
                            cover.setBounds(236,30,350,410);

                        }
                        if(i==3){
                            Thread.sleep(20);
                            cover.setBounds(177,30,350,410);
                        }
                        if(i==4){
                            Thread.sleep(20);
                            cover.setBounds(118,30,350,410);
                        }
                        if(i==5){
                            Thread.sleep(10);
                            setHideTxt(true);
                            cover.setBounds(59,30,350,410);
                        }
                        if(i==6){
                            Thread.sleep(30);
                            cover.setBounds(0,30,350,410);
                            setSignUpForm(true);
                        }
                    }
                }
                catch(Exception e){
                    
                }
            }
        }).start();
    }
    
    void setBackPanel(){
        new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    for(int i=0; i<=6; i++){
                        Thread.sleep(130);
                        if(i==1){
                            Thread.sleep(20);
                            cover.setBounds(59,30,350,410);
                            setSignUpForm(false);
                        }
                        if(i==2){
                            Thread.sleep(20);
                            cover.setBounds(118,30,350,410);
                        }
                        if(i==3){
                            Thread.sleep(20);
                            cover.setBounds(177,30,350,410);
                        }
                        if(i==4){
                            Thread.sleep(20);
                            cover.setBounds(236,30,350,410);
                        }
                        if(i==5){
                            Thread.sleep(20);
                            cover.setBounds(295,30,350,410);
                        }
                        if(i==6){
                            Thread.sleep(30);
                            cover.setBounds(350,30,350,410);      
                            setLoginForm(true);
                            register.setVisible(true);

                        }
                    }
                }
                catch(Exception e){
                    
                }
            }
        }).start();
    }
    
    void getTblName(){
        String userReg=user.getText();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
    
            sql="select * from db_signup where username=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, userReg);
            rs=ps.executeQuery();
                
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Name already existed!","Error",0);
                user.setText("");
            }
            
            else{
                setUserId();
                setSignUpInfo();
            }
         }
        
        catch (ClassNotFoundException ex) {
            Logger.getLogger(login404.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(login404.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Statement s;
    String userId;
    
    void setUserId(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            s=conn.createStatement();
            rs=s.executeQuery("select Max(id) from db_signup");
            rs.next();
            
            rs.getString("Max(id)");
            
            if(rs.getString("Max(id)")==null){
                userId="CVSU001";
            }
            else{
                Long id=Long.parseLong(rs.getString("Max(id)").substring(4,rs.getString("Max(id)").length()));
                id++;
                userId="CVSU"+String.format("%03d",id);
            }
            
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(login404.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(login404.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setSignUpInfo(){
        String ln=last.getText(); 
        String fn=first.getText(); 
        String mn=middle.getText(); 
        String setAge=age.getText(); 
        String setGender=gender.getText(); 
        String setAddress=address.getText(); 
        String setNumber=number.getText(); 
        String setEmail=email.getText(); 
        String setPosition=position.getText(); 
        String userReg=user.getText(); 
        String passReg=pass.getText(); 
        String type="Librarian";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
                        
            sql="insert into db_signup(id,last,first,middle,age,gender,address,contact,email,position,username,password,type)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, ln);
            ps.setString(3, fn);
            ps.setString(4, mn);
            ps.setString(5, setAge);
            ps.setString(6, setGender);
            ps.setString(7, setAddress);
            ps.setString(8, setNumber);
            ps.setString(9, setEmail);
            ps.setString(10, setPosition);
            ps.setString(11, userReg);
            ps.setString(12, passReg);
            ps.setString(13, type);
            ps.executeUpdate();
                       
            JOptionPane.showMessageDialog(null, "You are successfully register!", "Sucessful", 1);
            
            last.setText(""); 
            first.setText(""); 
            middle.setText(""); 
            age.setText(""); 
            gender.setText(""); 
            address.setText(""); 
            number.setText(""); 
            email.setText(""); 
            position.setText(""); 
            user.setText(""); 
            pass.setText(""); 
            conpass.setText(""); 
            
            setBackPanel();
            }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(login404.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(login404.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setLoginInfo(){
        String userLog=username.getText();
        String passLog=password.getText();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("select * from db_signup where username=? and password=?");
            ps.setString(1, userLog);
            ps.setString(2, passLog);
            rs=ps.executeQuery();
            
            if(rs.next()){
                workStatus="Log In";
                String typeAcc=rs.getString("type");
                if(typeAcc.equals("Admin")){
                    String fullName=rs.getString("first")+" "+rs.getString("Middle")+" "+rs.getString("last");
                    name=fullName;
                    type=typeAcc;
                    setStatus(workStatus);
                    JOptionPane.showMessageDialog(null, "Sucessful!! Wait for any momment!", "Message", 1);
                    new homepage().setVisible(true);
                    this.dispose();
                }
                else if(typeAcc.equals("Librarian")){
                    String fullName=rs.getString("first")+" "+rs.getString("Middle")+" "+rs.getString("last");
                    name=fullName;
                    type=typeAcc;
                    setStatus(workStatus);
                    JOptionPane.showMessageDialog(null, "Sucessful!! Wait for any momment!", "Message", 1);
                    new librarian().setVisible(true);
                    this.dispose();
                }
                

            }
            
            else if(username.getText().isEmpty()||password.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "You must enter your account", "Error", 0);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Account Does'nt Exist", "Error", 0);
            }
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(login404.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(login404.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    String workStatus;
    
    void setStatus(String status){
        date=new Date();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("insert into db_worklog(date,time,type,name,status) values(?,?,?,?,?)");
            ps.setString(1, format.format(date));
            ps.setString(2, format1.format(date));
            ps.setString(3, type);
            ps.setString(4, name);
            ps.setString(5, status);
            ps.executeUpdate();
        }
        
        
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cover = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        register = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        loginForm = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        returnBookBtn = new javax.swing.JPanel();
        login = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        signupForm = new javax.swing.JPanel();
        issueBookBtn = new javax.swing.JPanel();
        cancel = new javax.swing.JLabel();
        issueBookBtn1 = new javax.swing.JPanel();
        create = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        last = new javax.swing.JTextField();
        first = new javax.swing.JTextField();
        middle = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        gender = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        number = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        position = new javax.swing.JTextField();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        conpass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cover.setBackground(new java.awt.Color(248, 176, 154));
        cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(249, 142, 138));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register.setFont(new java.awt.Font("Kartika", 0, 14)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register.setText("Create account? Click Me!");
        register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registerMousePressed(evt);
            }
        });
        jPanel4.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 30));

        cover.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 350, 300, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/school/cvsu.png"))); // NOI18N
        jLabel5.setToolTipText("");
        cover.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, 300, 300));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        cover.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 410));

        getContentPane().add(cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 350, 410));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginForm.setBackground(new java.awt.Color(255, 153, 153));
        loginForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Username");
        loginForm.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 120, 200, -1));

        username.setBackground(new java.awt.Color(248, 176, 154));
        username.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        username.setCaretColor(new java.awt.Color(255, 255, 255));
        loginForm.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 140, 200, 25));

        jLabel18.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Password");
        loginForm.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 180, 200, -1));

        returnBookBtn.setBackground(new java.awt.Color(140, 140, 250));
        returnBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        returnBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnBookBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setText("Log In");
        login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginMousePressed(evt);
            }
        });
        returnBookBtn.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 25));

        loginForm.add(returnBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 250, 80, 25));

        password.setBackground(new java.awt.Color(248, 176, 154));
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        password.setCaretColor(new java.awt.Color(255, 255, 255));
        loginForm.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 200, 200, 25));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/user_male_circle_100px.png"))); // NOI18N
        loginForm.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        loginForm.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 350));

        jPanel3.add(loginForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 350));

        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 350));

        signupForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issueBookBtn.setBackground(new java.awt.Color(250, 140, 140));
        issueBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        issueBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueBookBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancel.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancel.setText("Cancel");
        cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelMousePressed(evt);
            }
        });
        issueBookBtn.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 25));

        signupForm.add(issueBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 310, 80, 25));

        issueBookBtn1.setBackground(new java.awt.Color(140, 140, 250));
        issueBookBtn1.setForeground(new java.awt.Color(255, 255, 255));
        issueBookBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueBookBtn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        create.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create.setText("Sign Up");
        create.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createMousePressed(evt);
            }
        });
        issueBookBtn1.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 25));

        signupForm.add(issueBookBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 310, 80, 25));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        last.setBackground(new java.awt.Color(248, 176, 154));
        last.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        last.setForeground(new java.awt.Color(255, 255, 255));
        last.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        last.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        last.setCaretColor(new java.awt.Color(255, 255, 255));
        last.setFocusable(false);
        jPanel2.add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 12, 90, 25));

        first.setBackground(new java.awt.Color(248, 176, 154));
        first.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        first.setForeground(new java.awt.Color(255, 255, 255));
        first.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        first.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        first.setCaretColor(new java.awt.Color(255, 255, 255));
        first.setFocusable(false);
        jPanel2.add(first, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 12, 90, 25));

        middle.setBackground(new java.awt.Color(248, 176, 154));
        middle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        middle.setForeground(new java.awt.Color(255, 255, 255));
        middle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        middle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        middle.setCaretColor(new java.awt.Color(255, 255, 255));
        middle.setFocusable(false);
        jPanel2.add(middle, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 12, 80, 25));

        age.setBackground(new java.awt.Color(248, 176, 154));
        age.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        age.setForeground(new java.awt.Color(255, 255, 255));
        age.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        age.setCaretColor(new java.awt.Color(255, 255, 255));
        age.setFocusable(false);
        age.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ageFocusLost(evt);
            }
        });
        age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ageKeyTyped(evt);
            }
        });
        jPanel2.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 55, 60, 25));

        gender.setBackground(new java.awt.Color(248, 176, 154));
        gender.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        gender.setForeground(new java.awt.Color(255, 255, 255));
        gender.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        gender.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 55, 80, 25));

        address.setBackground(new java.awt.Color(248, 176, 154));
        address.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        address.setForeground(new java.awt.Color(255, 255, 255));
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        address.setCaretColor(new java.awt.Color(255, 255, 255));
        address.setFocusable(false);
        jPanel2.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 85, 260, 25));

        number.setBackground(new java.awt.Color(248, 176, 154));
        number.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        number.setForeground(new java.awt.Color(255, 255, 255));
        number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        number.setCaretColor(new java.awt.Color(255, 255, 255));
        number.setFocusable(false);
        number.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numberFocusLost(evt);
            }
        });
        number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numberKeyTyped(evt);
            }
        });
        jPanel2.add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 115, 130, 25));

        email.setBackground(new java.awt.Color(248, 176, 154));
        email.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        email.setCaretColor(new java.awt.Color(255, 255, 255));
        email.setFocusable(false);
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 145, 130, 25));

        position.setBackground(new java.awt.Color(248, 176, 154));
        position.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        position.setForeground(new java.awt.Color(255, 255, 255));
        position.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        position.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        position.setCaretColor(new java.awt.Color(255, 255, 255));
        position.setFocusable(false);
        jPanel2.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 175, 130, 25));

        user.setBackground(new java.awt.Color(248, 176, 154));
        user.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        user.setCaretColor(new java.awt.Color(255, 255, 255));
        user.setFocusable(false);
        jPanel2.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 205, 150, 25));

        pass.setBackground(new java.awt.Color(248, 176, 154));
        pass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        pass.setCaretColor(new java.awt.Color(255, 255, 255));
        pass.setFocusable(false);
        jPanel2.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 235, 150, 25));

        conpass.setBackground(new java.awt.Color(248, 176, 154));
        conpass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        conpass.setForeground(new java.awt.Color(255, 255, 255));
        conpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        conpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        conpass.setCaretColor(new java.awt.Color(255, 255, 255));
        conpass.setFocusable(false);
        jPanel2.add(conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 265, 150, 25));

        jLabel6.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 35, -1));

        jLabel7.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Age");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Gender");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Address");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Contact Number");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Email");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel12.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Position");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel13.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Username");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel14.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Password");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel15.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Confirm Password");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 255, 255));
        jLabel19.setText("Last");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 40, -1, 10));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 255, 255));
        jLabel20.setText("First");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, 10));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 255, 255));
        jLabel21.setText("Middle");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 40, -1, 10));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black3.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 350));

        signupForm.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 350));

        jPanel3.add(signupForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 350, 350));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 350));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 470));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMousePressed
        setBackPanel();
    }//GEN-LAST:event_cancelMousePressed

    private void loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMousePressed
        setLoginInfo();
    }//GEN-LAST:event_loginMousePressed

    private void registerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMousePressed
        String code=JOptionPane.showInputDialog(null,"Enter your registration code","Authentication Code",3);
        if(code.equals("123456")){
            setMovePanel();
        }
        else{
            JOptionPane.showMessageDialog(null,"Your Registration Code is incorrect!","Error",0);
        }
    }//GEN-LAST:event_registerMousePressed

    private void createMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMousePressed
          
        if(last.getText().isEmpty()||first.getText().isEmpty()
            ||middle.getText().isEmpty()||age.getText().isEmpty()
            ||gender.getText().isEmpty()||address.getText().isEmpty()
            ||number.getText().isEmpty()||email.getText().isEmpty()
            ||position.getText().isEmpty()||user.getText().isEmpty()
            ||pass.getText().isEmpty()||conpass.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Fill all information needed!","Error",0);
                last.setText("");
                first.setText("");
                middle.setText("");
                age.setText("");
                email.setText("");
                number.setText("");
                address.setText("");
                position.setText("");
                user.setText("");
                pass.setText("");
                conpass.setText("");
                gender.setText("");
        }
        else if(age.getText().length()>=3){
            JOptionPane.showMessageDialog(null,"The age is too much!","Error",0);
            age.setText("");
        }
        else if(number.getText().length()>11||number.getText().length()<11){
            JOptionPane.showMessageDialog(null,"The number must be exact 11!","Error",0);
            number.setText("");
        }
        else if(!pass.getText().equals(conpass.getText())){
                JOptionPane.showMessageDialog(null,"Password Does'nt Match!","Error",0);
                pass.setText("");
                conpass.setText("");
        }
        else if(pass.getText().length()<6){
            if(pass.getText().equals(conpass.getText())){
                JOptionPane.showMessageDialog(null,"Password too short","Error",0);
            }
        }
        else if(pass.getText().length()>=6){
            //information 
            if(pass.getText().equals(conpass.getText())){
                getTblName();
            }
        }
        
    }//GEN-LAST:event_createMousePressed

    private void ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageKeyTyped
        char c= evt.getKeyChar();
        if(Character.isLetter(c)){
            age.setEditable(false);
        }
        else{
            if(age.getText().length()<=2){
                age.setEditable(true);
            }
            else{
                age.setEditable(false);
            }
        }
        
    }//GEN-LAST:event_ageKeyTyped

    private void ageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageFocusGained
        age.setEditable(true);
    }//GEN-LAST:event_ageFocusGained

    private void ageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageFocusLost
        age.setEditable(true);
    }//GEN-LAST:event_ageFocusLost

    private void numberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberKeyTyped
        char d= evt.getKeyChar();
        if(Character.isLetter(d)){
            number.setEditable(false);
        }
        else{
            if(number.getText().length()<=11){
                number.setEditable(true);
            }
            else{
                number.setEditable(false);
            }
        }
    }//GEN-LAST:event_numberKeyTyped

    private void numberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numberFocusGained
        number.setEditable(true);
    }//GEN-LAST:event_numberFocusGained

    private void numberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numberFocusLost
        number.setEditable(true);
    }//GEN-LAST:event_numberFocusLost
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login404.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login404.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login404.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login404.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login404().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JLabel cancel;
    private javax.swing.JPasswordField conpass;
    private javax.swing.JPanel cover;
    private javax.swing.JLabel create;
    private javax.swing.JTextField email;
    private javax.swing.JTextField first;
    private javax.swing.JTextField gender;
    private javax.swing.JPanel issueBookBtn;
    private javax.swing.JPanel issueBookBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField last;
    private javax.swing.JLabel login;
    private javax.swing.JPanel loginForm;
    private javax.swing.JTextField middle;
    private javax.swing.JTextField number;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField position;
    private javax.swing.JLabel register;
    private javax.swing.JPanel returnBookBtn;
    private javax.swing.JPanel signupForm;
    private javax.swing.JTextField user;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
