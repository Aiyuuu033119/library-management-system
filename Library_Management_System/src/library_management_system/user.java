
package library_management_system;

import java.awt.Color;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.*;
import javax.swing.JFrame;

public class user extends javax.swing.JFrame {

    int me=123;
    
    Connection conn; 
    PreparedStatement ps;   
    ResultSet rs; 
    
    String chbxCourse1;
    String chbxDate1;
    
    Date dates;
    DateFormat format=new SimpleDateFormat("MM/dd/YYYY");
    DateFormat format1=new SimpleDateFormat("hh:mm");
    
    String time;
    
    public user() {
        initComponents();
        setLocationRelativeTo(null);
        setHideBody(trans,false);
        setTblDesign(table);
        setColumnUsers(table);
    }

    
    void setHideBody(JPanel hideBody,Boolean hide){
       hideBody.setVisible(hide);
       hideBody.setEnabled(hide);
    }
    
    void setActiveBody(JPanel hideBody,Boolean hide){
       hideBody.setVisible(hide);
       hideBody.setEnabled(hide);
    }
    
    void setTblDesign(JTable tblLook){
        tblLook.getTableHeader().setFont(new Font("Kartika", Font.BOLD,12));
        tblLook.getTableHeader().setOpaque(false);
        tblLook.getTableHeader().setBackground(new Color(146,148,148));
        tblLook.getTableHeader().setForeground(new Color(255,255,255));
        tblLook.setRowHeight(20);
        ((DefaultTableCellRenderer)tblLook.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
    }
    
    void setColumnUsers(JTable table){
        TableColumn col;
        DefaultTableCellRenderer center= new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        
        col=table.getColumnModel().getColumn(0);
        col.setPreferredWidth(45);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(1);
        col.setPreferredWidth(100);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(3);
        col.setPreferredWidth(45);
        col.setCellRenderer(center);
    }

    void getUserDate(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_libraryusers group by date order by date desc");
            rs=ps.executeQuery();
            
            chbxDate.addItem("Select All Dates");
            while(rs.next()){
                chbxDate.addItem(rs.getString("date"));
            }

            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setLibraryUserData(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_libraryusers where date=?");
            ps.setString(1, chbxDate1);
            rs=ps.executeQuery();
            
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            model.setRowCount(0);
            table.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("date"),rs.getString("studentNo"),rs.getString("name"),rs.getString("section")};
                model.addRow(me);
            }
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setLibraryUser(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_libraryusers order by date,time desc");
            rs=ps.executeQuery();
            
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            model.setRowCount(0);
            table.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("date"),rs.getString("studentNo"),rs.getString("name"),rs.getString("section")};
                model.addRow(me);
            }
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void DisplayUserData(){
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select * from db_libraryusers where date=? and course=?");
                ps.setString(1, chbxDate1);
                ps.setString(2, chbxCourse1);
                rs=ps.executeQuery();

                DefaultTableModel model=(DefaultTableModel)table.getModel();
                model.setRowCount(0);
                table.setModel(model);

                while(rs.next()){
                    Object me[]={rs.getString("date"),rs.getString("studentNo"),rs.getString("name"),rs.getString("section")};
                    model.addRow(me);
                }
            }
            catch (ClassNotFoundException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    void setUpdateChbxUser(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_libraryusers where date=?");
            ps.setString(1, chbxDate1);
            rs=ps.executeQuery();
            
            chbxDate.removeAllItems();
            
            chbxDate.addItem("Select All Dates");
            while(rs.next()){
                chbxDate.addItem(rs.getString("date"));
            }
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setAddUsers(){
        String libName=name.getText();
        String libSection=section.getText();
        String libStdNo=stdNo.getText();
        String libDate=date.getText(); 
        String libCourse=(String)course.getSelectedItem();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("insert into db_libraryusers(date,time,name,studentNo,section,course) values(?,?,?,?,?,?)");
            ps.setString(1, libDate);
            ps.setString(2, time);
            ps.setString(3, libName);
            ps.setString(4, libStdNo);
            ps.setString(5, libSection);
            ps.setString(6, libCourse);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"The book is successfully saved!","Successful",1);
            
            setUserList(date.getText());
            
            name.setText("");
            section.setText("");
            stdNo.setText("");
            course.setSelectedIndex(0);
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setUserList(String dateHis){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_libraryusers where date=?");
            ps.setString(1, dateHis);
            rs=ps.executeQuery();
            
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            model.setRowCount(0);
            table.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("date"),rs.getString("studentNo"),rs.getString("name"),rs.getString("section")};
                model.addRow(me);
            }
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainbody = new javax.swing.JPanel();
        head = new javax.swing.JPanel();
        logoName = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        logo1 = new javax.swing.JLabel();
        logo2 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        welcome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        trans = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        chbxDate = new javax.swing.JComboBox<>();
        chbxCourse = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        course = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        section = new javax.swing.JTextField();
        stdNo = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        no = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainbody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head.setBackground(new java.awt.Color(51, 51, 51));
        head.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoName.setFont(new java.awt.Font("Kartika", 0, 18)); // NOI18N
        logoName.setForeground(new java.awt.Color(255, 255, 255));
        logoName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoName.setText("CVSu-Library");
        head.add(logoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 6, 120, 30));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/book_shelf_35px.png"))); // NOI18N
        logo.setText("`");
        logo.setFocusable(false);
        head.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 35, 40));

        logo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/minimize_window_20px.png"))); // NOI18N
        logo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logo1.setFocusable(false);
        logo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logo1MousePressed(evt);
            }
        });
        head.add(logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 18, 18));

        logo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/close_window_20px.png"))); // NOI18N
        logo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logo2.setFocusable(false);
        logo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logo2MousePressed(evt);
            }
        });
        head.add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 18, 18));

        mainbody.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 976, 40));

        body.setPreferredSize(new java.awt.Dimension(750, 460));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcome.setBackground(new java.awt.Color(134, 191, 230));
        welcome.setPreferredSize(new java.awt.Dimension(750, 460));
        welcome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Kartika", 1, 56)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><center>WELCOME</center></html>");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        welcome.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 320, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/school/cvsu.png"))); // NOI18N
        welcome.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 300, 230));

        jPanel4.setBackground(new java.awt.Color(250, 150, 150));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Kartika", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Okay");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        welcome.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, 70, 30));

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "<html><head><style> body{background-color:white; padding:5px; border:2px solid black; }</style></head><body>   CVSU LIBRARY  </body></html>", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Imprint MT Shadow", 0, 24))); // NOI18N
        welcome.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 800, 400));

        body.add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 976, 575));

        trans.setBackground(new java.awt.Color(134, 191, 230));
        trans.setPreferredSize(new java.awt.Dimension(750, 460));
        trans.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Student No.", "Name", "Section"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionBackground(new java.awt.Color(249, 142, 138));
        jScrollPane1.setViewportView(table);

        trans.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 660, 340));

        chbxDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        chbxDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                chbxDateFocusGained(evt);
            }
        });
        chbxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxDateActionPerformed(evt);
            }
        });
        trans.add(chbxDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 130, 25));

        chbxCourse.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        chbxCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select All Courses", "BSIT", "BSCS", "BSHM", "BSBM", "BSC", "BSP", "BSE" }));
        chbxCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxCourseActionPerformed(evt);
            }
        });
        trans.add(chbxCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 150, 25));

        jLabel14.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Library User");
        trans.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Kartika", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Name");
        trans.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 200, -1));

        jLabel9.setFont(new java.awt.Font("Kartika", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Student No.");
        trans.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 200, -1));

        jLabel10.setFont(new java.awt.Font("Kartika", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Section");
        trans.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 200, -1));

        jLabel11.setFont(new java.awt.Font("Kartika", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Course");
        trans.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 200, -1));

        course.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course", "BSIT", "BSCS", "BSHM", "BSBM", "BSC", "BSP", "BSE", " " }));
        trans.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, 200, 25));

        jLabel12.setFont(new java.awt.Font("Kartika", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Date");
        trans.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 200, -1));

        jPanel3.setBackground(new java.awt.Color(150, 150, 250));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Enter");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 25));

        trans.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 469, 70, 25));

        date.setEditable(false);
        date.setBackground(new java.awt.Color(248, 176, 154));
        date.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        date.setCaretColor(new java.awt.Color(255, 255, 255));
        trans.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 200, 25));

        section.setBackground(new java.awt.Color(248, 176, 154));
        section.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        section.setForeground(new java.awt.Color(255, 255, 255));
        section.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        section.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        section.setCaretColor(new java.awt.Color(255, 255, 255));
        trans.add(section, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 200, 25));

        stdNo.setBackground(new java.awt.Color(248, 176, 154));
        stdNo.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        stdNo.setForeground(new java.awt.Color(255, 255, 255));
        stdNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stdNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        stdNo.setCaretColor(new java.awt.Color(255, 255, 255));
        trans.add(stdNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 200, 25));

        name.setBackground(new java.awt.Color(248, 176, 154));
        name.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        name.setCaretColor(new java.awt.Color(255, 255, 255));
        trans.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 200, 25));

        jPanel1.setBackground(new java.awt.Color(134, 191, 230));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        no.setEditable(false);
        no.setBackground(new java.awt.Color(248, 176, 154));
        no.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        no.setForeground(new java.awt.Color(255, 255, 255));
        no.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        no.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(no, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 30, 40, 25));

        jLabel13.setFont(new java.awt.Font("Kartika", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("SEARCH");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 70, 25));

        jLabel16.setFont(new java.awt.Font("Kartika", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("No. of Books");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 80, 25));

        search.setBackground(new java.awt.Color(248, 176, 154));
        search.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        search.setCaretColor(new java.awt.Color(255, 255, 255));
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 200, 25));

        jLabel17.setFont(new java.awt.Font("Kartika", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Status");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 30, 50, 25));

        status.setEditable(false);
        status.setBackground(new java.awt.Color(248, 176, 154));
        status.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        status.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 30, 110, 25));

        trans.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 80));

        jLabel15.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Log In");
        trans.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 270, -1));

        jPanel2.setBackground(new java.awt.Color(134, 191, 230));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        trans.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 700, 460));

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        trans.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 240, 410));

        jPanel5.setBackground(new java.awt.Color(134, 191, 230));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        trans.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 280, 540));

        body.add(trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 976, 535));

        mainbody.add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 976, 535));

        getContentPane().add(mainbody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 976, 575));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        setHideBody(welcome,false);
        setActiveBody(trans,true);
        dates=new Date();
        date.setText(format.format(dates));
        getUserDate();
    }//GEN-LAST:event_jLabel4MousePressed

    private void chbxDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chbxDateFocusGained
        //setUpdateChbxUser();
    }//GEN-LAST:event_chbxDateFocusGained

    private void chbxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxDateActionPerformed
        chbxDate1=(String)chbxDate.getSelectedItem();
        chbxCourse1=(String)chbxCourse.getSelectedItem();
        
        if(chbxDate1.equals("Select All Dates")&&chbxCourse1.equals("Select All Courses")){
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            model.setRowCount(0);
            table.setModel(model);
        }
        else if(chbxCourse1.equals("Select All Courses")){
            setLibraryUserData();
        }

    }//GEN-LAST:event_chbxDateActionPerformed

    private void chbxCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxCourseActionPerformed
        chbxDate1=(String)chbxDate.getSelectedItem();
        chbxCourse1=(String)chbxCourse.getSelectedItem(); 
        
        if(chbxDate1.equals("Select All Dates")&&chbxCourse1.equals("Select All Courses")){
            setLibraryUser();
        }
        else if(chbxCourse1.equals("Select All Courses")){
            setLibraryUserData();
        }
        else{
            DisplayUserData();
        }

    }//GEN-LAST:event_chbxCourseActionPerformed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed

        String course_category=(String)course.getSelectedItem();
        dates=new Date();
        time=format1.format(dates);
        if(name.getText().isEmpty()||section.getText().isEmpty()
            ||stdNo.getText().isEmpty()||course_category.equals("Select Course")){

            JOptionPane.showMessageDialog(null,"Fill all information needed!");
            name.setText("");
            section.setText("");
            stdNo.setText("");
            course.setSelectedIndex(0);
        }
        else{
            setAddUsers();
        }

    }//GEN-LAST:event_jLabel5MousePressed

    private void logo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo2MousePressed
        System.exit(0);
    }//GEN-LAST:event_logo2MousePressed

    private void logo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo1MousePressed
        this.setExtendedState(user.ICONIFIED);
    }//GEN-LAST:event_logo1MousePressed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        if(search.getText().isEmpty()){
            status.setText("");
            no.setText("");
        }
        else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select * from db_booklist where title like '%"+search.getText()+"%' ");
                rs=ps.executeQuery();


                if(rs.next()){
                    String title=rs.getString("title");
                    int available=rs.getInt("returnBook");
                    if(available>=1){
                        status.setText("Available");
                        no.setText(Integer.toString(available));
                    }
                    else if(available==0)
                        status.setText("Not Availalble");
                        no.setText(Integer.toString(available));
                }
                else{
                    status.setText("Not Existed");
                    no.setText("0");
                }

            }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_searchKeyReleased

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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JComboBox<String> chbxCourse;
    private javax.swing.JComboBox<String> chbxDate;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JTextField date;
    private javax.swing.JPanel head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo1;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel logoName;
    private javax.swing.JPanel mainbody;
    private javax.swing.JTextField name;
    private javax.swing.JTextField no;
    private javax.swing.JTextField search;
    private javax.swing.JTextField section;
    private javax.swing.JTextField status;
    private javax.swing.JTextField stdNo;
    private javax.swing.JTable table;
    private javax.swing.JPanel trans;
    private javax.swing.JPanel welcome;
    // End of variables declaration//GEN-END:variables
}
