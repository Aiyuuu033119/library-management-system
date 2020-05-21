
package library_management_system;

import java.awt.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import static library_management_system.homepage.typeAcc;

public class librarian extends javax.swing.JFrame {

    int me=288;
    
    int page;
    int exit;
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;
    
    Date date;
    DateFormat format=new SimpleDateFormat("MM/dd/YYYY");
    DateFormat format1=new SimpleDateFormat("MM/dd/YYYY - hh:mm");
    
    int quantity;
    int issuedBook;
    int borrowQuan;
    int select;
    
    String historyId;
    String bookIDS;
    
    int lengths;
    
    String bookCategories;
    String search;
    
    String borrowed;
    
    String state;
    
    String issuesId;
    String issuesTitle;
    String issuesAuthor;
    String issuesCategory;
    int returnBooks;
    int issueBooks;
    
    static String fullName;
    static String typeAcc;
    
    public librarian() {
        initComponents();
        setLocationRelativeTo(null);
        
        fullName=new login404().name;
        typeAcc=new login404().type;
        
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,issueBooksPage,transactionPage,false);
        transparentPanelGroup();
        setActive(dashboardBtn,homePage);
        setSlideShow();
        setTblDesign(bookTable);
        setTblDesign(issueMultipleBooks);
        setColumnBookList(bookTable);
        setColumnIssue(issueMultipleBooks);
        setBookList();
    }

    void setTblDesign(JTable tblLook){
        tblLook.getTableHeader().setFont(new Font("Kartika", Font.BOLD,12));
        tblLook.getTableHeader().setOpaque(false);
        tblLook.getTableHeader().setBackground(new Color(146,148,148));
        tblLook.getTableHeader().setForeground(new Color(255,255,255));
        tblLook.setRowHeight(20);
        ((DefaultTableCellRenderer)tblLook.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
    }
    
    void setColumnIssue(JTable table){ 
        TableColumn col;
        DefaultTableCellRenderer center= new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        
        col=table.getColumnModel().getColumn(0);
        col.setPreferredWidth(35);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(1);
        col.setPreferredWidth(100);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(3);
        col.setPreferredWidth(35);
        col.setCellRenderer(center);
    }
    
    void setColumnBookList(JTable table){
        TableColumn col;
        DefaultTableCellRenderer center= new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);

        col=table.getColumnModel().getColumn(0);
        col.setPreferredWidth(25);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(1);
        col.setPreferredWidth(110);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(2);
        col.setPreferredWidth(110);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(3);
        col.setPreferredWidth(35);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(4);
        col.setPreferredWidth(30);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(5);
        col.setPreferredWidth(30);
        col.setCellRenderer(center);
        
    }
    
    //set Jpanel to tranparent
    void setPanelTranparent(JPanel transparent){
        transparent.setBackground(new Color(0,0,0,0));        
    }
    
    void transparentPanelGroup(){
        setPanelTranparent(sideNav);
        setPanelTranparent(body);
        setPanelTranparent(homePage);
        setPanelTranparent(bookListPage);
        setPanelTranparent(issueBookPage);
        setPanelTranparent(returnBookPage);
        setPanelTranparent(issueBox);
        setPanelTranparent(returnBox);
        setPanelTranparent(issueBooksPage);    
    }
    
    void setActive(JPanel active,JPanel page){
        active.setBackground(new Color(249,142,138));   
        
        page.setVisible(true);
        page.setEnabled(true);
    }
    
    //set sidenav to diff. colors
    void setBtnHover(JPanel btnHover,int red,int green,int blue){
        btnHover.setBackground(new Color(red,green,blue));
    }   
    
    //hiding other panel
    void setHideBody(JPanel hideBody,Boolean hide){
       hideBody.setVisible(hide);
       hideBody.setEnabled(hide);
    }
    
    //sets of Jpanel to be hide
    void hidePanelGroup(JPanel pg1, JPanel pg2, JPanel pg3, Boolean hide){
        setHideBody(pg1,hide);
        setHideBody(pg2,hide);
        setHideBody(pg3,hide);
    }
    
    //set image to the Jlabel 
    void setImage(String path, int picNumber){
        picContainer.setIcon(new ImageIcon(getClass().getResource(path)));
                                
        page=picNumber;
    }
    
    //set description to Jlabel
    void setTitleName(String title){
        titleDes.setText(title);
    }
    
    void setDescription(String descript){
        description.setText(descript);
    }
    
    //setting slideshow
    void setSlideShow(){
        new Thread(new Runnable() {
            
            @Override
            public void run(){
                try{
                   while(true){
                        switch(page){
                            case 0:{
                                Thread.sleep(3000);
                                setImage("/icons/school/entrance.png",1);
                                setTitleName("<html><b>UNIVERSITY VISSION</b></html>");
                                description.setFont(new Font("Kartika",0,13));
                                setDescription("<html><center>“The premier University in historic Cavite\n" +
                                "recognized for excellence in the \n" +
                                "development of globally competitive\n" +
                                "and morally upright individuals.” <center> </html>");
                                break;
                            }
                            case 1:{
                                Thread.sleep(3000);
                                setImage("/icons/school/hallway.png",2);
                                setTitleName("<html><b>UNIVERSITY MISSION</b></html>");
                                description.setFont(new Font("Kartika",0,11));
                                setDescription("<html><center> “Cavite State University shall provide \n" +
                                "excellence, equitable and relevant educational\n" +
                                " opportunities in the arts, sciences and \n" +
                                "technology through quality instruction and \n" +
                                "responsive research and development \n" +
                                "activities.” <br><br>\n" +
                                "\n" +
                                "“It shall produce professional, skilled and \n" +
                                "morally upright individuals for global \n" +
                                "competitiveness.” </center></html>");
                                break;
                            }
                            case 2:{
                                Thread.sleep(3000);
                                setImage("/icons/school/canteen.png",3);
                                setTitleName("<html><b>LIBRARY VISSION</b></html>");
                                description.setFont(new Font("Kartika",0,13));
                                setDescription("<html><center>“To promote the humble existence and \n" +
                                "importance of library in an institution and to\n" +
                                "its community through quality education\n" +
                                "where can be develop and produce morally\n" +
                                "upright and competitive individuals.”</center></html>");
                                break;
                            }
                            case 3:{
                                Thread.sleep(3000);
                                setImage("/icons/school/tambayan.png",4);
                                setTitleName("<html><b>LIBRARY MISSION</b></html>");
                                description.setFont(new Font("Kartika",0,13));
                                setDescription("<html><center>“To support the institution’s mission in its\n" +
                                "Commitment to produce individuals with\n" +
                                "Truth, excellence and service in any phases\n" +
                                "and trends of life.”</center></html>");
                                break;
                            }
                            case 4:{
                                Thread.sleep(3000);
                                setImage("/icons/school/newB.png",5);
                                setTitleName("<html><b>LIBRARY HOURS</b></html>");
                                description.setFont(new Font("Kartika",0,20));
                                setDescription("<html><center>“Monday to Thursday 7:00am-6:00pm”</center></html>");
                                break;
                            }
                            case 5:{
                                Thread.sleep(3000);
                                setImage("/icons/school/ilovecvsu.png",0);
                                setTitleName("<html><b>CVSU LIBRARY - BACOOR CITY CAMPUS</b></html>");
                                description.setFont(new Font("Kartika",0,12));
                                setDescription("<html><center>”A reader lives a thousand lives before he dies”<br><br>-Gerorge R. R. Martin<center> </html>");
                                break;
                            }
                        }
                   } 
                }
                catch(Exception e){
                    
                }
            }
        }).start();
    }
    
    void setIssuePanel(JPanel btn,JPanel btn1,JPanel btn2){
        hidePanelGroup(bookListPage,transactionPage,issueBooksPage,false);
        hidePanelGroup(returnBookPage,homePage,homePage,false);
        setActive(btn,btn2);
        setBtnHover(btn1, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
    }
    
    void setIssuesPanel(JPanel btn,JPanel btn1,JPanel btn2){
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,homePage,homePage,false);
        setActive(btn,btn2);
        setBtnHover(btn1, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
    }
    
    void setReturnPanel(JPanel btn, JPanel btn1){
        hidePanelGroup(bookListPage,transactionPage,issueBooksPage,false);
        hidePanelGroup(issueBookPage,homePage,homePage,false);
        setActive(btn,returnBookPage);
        setBtnHover(btn1, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
    }
    
    long setNextDate(Date nextDate){
        long subtract=(nextDate.getTime()+(5*86400000));
        return Math.abs(subtract);
    } 
    
    void setIssueTransaction(){
        String stdId=issueStudentId.getText();
        String stdName=issueStudentName.getText();
        String stdYS=issueYearSection.getText();
        String book_Id=issueBookID.getText();
        String book_title=issueTitle.getText();
        String book_author=issueAuthor.getText();
        String book_category=issueCategory.getText();
        String book_date=issueDate.getText();
        String book_due=issueDueDate.getText();
        String issue="Issue Book";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("insert into db_transaction(studentId,name,yearSection, "
               + "bookId,title,author,category,action,date,duedate) values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,stdId);
            ps.setString(2,stdName);
            ps.setString(3,stdYS);
            ps.setString(4,book_Id);
            ps.setString(5,book_title);
            ps.setString(6,book_author);
            ps.setString(7,book_category);
            ps.setString(8,issue);
            ps.setString(9,book_date);
            ps.setString(10,book_due);
            ps.executeUpdate();

        }
        
        
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setHistoryId(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            s=conn.createStatement();
            rs=s.executeQuery("select Max(historyId) from db_history");
            rs.next();
            
            rs.getString("Max(historyId)");
            
            if(rs.getString("Max(historyId)")==null){
                historyId="TRANS001"; 
            }
            else{
                Long id=Long.parseLong(rs.getString("Max(historyId)").substring(5,rs.getString("Max(historyId)").length()));
                id++;
                historyId="TRANS"+String.format("%03d",id); 
            }
            
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setHistoryTransaction(){
        String stdId=issueStudentId.getText();
        String stdName=issueStudentName.getText();
        String stdYS=issueYearSection.getText();
        String book_Id=issueBookID.getText();
        String book_title=issueTitle.getText();
        String book_author=issueAuthor.getText();
        String book_category=issueCategory.getText();
        String book_date=issueDate.getText();
        String book_due=issueDueDate.getText();
        String issue="Issue Book";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("insert into db_history(historyId,studentId,name,yearSection, "
               + "bookId,title,author,category,action,date,duedate) values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,historyId); 
            ps.setString(2,stdId);
            ps.setString(3,stdName);
            ps.setString(4,stdYS);
            ps.setString(5,book_Id);
            ps.setString(6,book_title);
            ps.setString(7,book_author);
            ps.setString(8,book_category);
            ps.setString(9,issue);
            ps.setString(10,book_date);
            ps.setString(11,book_due);
            ps.executeUpdate();

            issueStudentId.setText("");
            issueStudentName.setText("");
            issueYearSection.setText("");
            issueBookID.setText("");
            issueTitle.setText("");
            issueAuthor.setText("");
            issueCategory.setText("");
            issueDate.setText("");
            issueDueDate.setText("");
        }
        
        
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setDeletingBooks(){
        int minus=borrowQuan-1;
        int plus=quantity+1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("update db_booklist set returnBook=?, issueBook=? where bookId=?");
            ps.setInt(1,plus);
            ps.setInt(2,minus);
            ps.setString(3,returnBookID.getText());
            ps.executeUpdate();

            setHistoryId();
            setReturnTransaction(); 
            setDeleteIssue(); 

            JOptionPane.showMessageDialog(null,"Return book sucessful","Message",1);
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void getReturnTransaction(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_transaction where bookId=?");
            ps.setString(1,bookIDS);  
            rs=ps.executeQuery();
            
            if(rs.next()){
                returnBookID.setText(rs.getString("bookId"));
                returnTitle.setText(rs.getString("title"));
                returnAuthor.setText(rs.getString("author"));
                returnCategory.setText(rs.getString("category"));
                issuedDate.setText(rs.getString("date"));
            }
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setReturnTransaction(){
        String stdId=returnStudentId.getText();
        String stdName=returnStudentName.getText();
        String stdYS=returnYearSection.getText();
        String book_Id=returnBookID.getText();
        String book_title=returnTitle.getText();
        String book_author=returnAuthor.getText();
        String book_category=returnCategory.getText();
        String book_date=issuedDate.getText();
        String book_due=returnDate.getText();
        String returnbook="Return Book";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("insert into db_history(historyId,studentId,name,yearSection, "
               + "bookId,title,author,category,action,date,dueDate) values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,historyId);
            ps.setString(2,stdId);
            ps.setString(3,stdName);
            ps.setString(4,stdYS);
            ps.setString(5,book_Id);
            ps.setString(6,book_title);
            ps.setString(7,book_author);
            ps.setString(8,book_category);
            ps.setString(9,returnbook);
            ps.setString(10,book_date);
            ps.setString(11,book_due);
            ps.executeUpdate();

            returnTitle.setText("");
            returnAuthor.setText("");
            returnCategory.setText("");
            returnDate.setText("");
            issuedDate.setText("");
        }
        
        
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setDeleteIssue(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("DELETE FROM db_transaction WHERE bookId=? and name=?");
            ps.setString(1,returnBookID.getText());
            ps.setString(2,returnStudentName.getText());
            ps.executeUpdate();

            returnStudentId.setText("");
            returnStudentName.setText("");
            returnYearSection.setText("");
            returnBookID.setText("");

        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setBookList(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_booklist");
            rs=ps.executeQuery();
            
            DefaultTableModel model=(DefaultTableModel)bookTable.getModel();
            model.setRowCount(0);
            bookTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("bookId"),rs.getString("title"),rs.getString("author"),rs.getString("category"),rs.getString("returnBook"),rs.getString("issueBook")};
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
    
    void setSelectIssue(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_booklist where bookId=?");
            ps.setString(1,bookIDS);
            rs=ps.executeQuery();
            
            if(rs.next()){
                issueBookID.setText(rs.getString("bookId"));
                issueTitle.setText(rs.getString("title"));
                issueAuthor.setText(rs.getString("author"));
                issueCategory.setText(rs.getString("category"));
                issuedBook=rs.getInt("issueBook"); 
            }
            issueDate.setText(format.format(date)); 
            long days=setNextDate(date); 
            issueDueDate.setText(format.format(days));
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setBookCategory(String bookCat){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("select * from db_booklist where category=?" );
            ps.setString(1,bookCat);
            rs=ps.executeQuery();

            DefaultTableModel model=(DefaultTableModel)bookTable.getModel();
            model.setRowCount(0);
            bookTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("bookId"),rs.getString("title"),rs.getString("author"),rs.getString("category"),rs.getString("returnBook"),rs.getString("issueBook")};
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
    
    void setBackArrow(){
        switch(exit){
            case 1:{
                issueBookID.setEnabled(true);
                issueBookID.setText("");
                issueTitle.setText("");
                issueAuthor.setText("");
                issueCategory.setText("");
                select=-1;
                bookIDS="";
                setBookList();
                category.setSelectedIndex(0);
                setBookListPanel(); 
                break;
            }
            case 2:{
                returnStudentId.setText("");
                returnStudentName.setText("");
                returnYearSection.setText("");
                returnBookID.setEnabled(true);
                returnBookID.setText("");
                returnTitle.setText("");
                returnAuthor.setText("");
                returnCategory.setText("");
                returnDate.setText("");
                issuedDate.setText("");
                select=-1;
                bookIDS="";
                setBookList();
                category.setSelectedIndex(0);
                setBookListPanel(); 
                break;
            }
            case 3:{
                setTransactionPanel(); 
                break;
            }
            case 4:{
                setTransactionPanel(); 
                break;
            }
            
        }
    }
    
    void setBookListPanel(){
        hidePanelGroup(homePage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,issueBooksPage,homePage,false);
        setActive(bookListButton,bookListPage);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        
        
    }

    void setTransactionPanel(){
        hidePanelGroup(bookListPage,homePage,issueBookPage,false);
        hidePanelGroup(returnBookPage,issueBooksPage,homePage,false);
        setActive(transactionButton,transactionPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        
    }
    
    void getIssuedBooks(String num){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("select * from db_booklist where bookId=?");
            ps.setString(1,num);
            rs=ps.executeQuery();
            
            if(rs.next()){
                issuesId=rs.getString("bookId");
                issuesTitle=rs.getString("title");
                issuesAuthor=rs.getString("author");
                issuesCategory=rs.getString("category");
                returnBooks=rs.getInt("returnBook");
                issueBooks=rs.getInt("issueBook");
                
                int minus=returnBooks-1;
                int plus=issueBooks+1; 
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                    ps=conn.prepareStatement("update db_booklist set returnBook=?, issueBook=? where bookId=?");
                    ps.setInt(1,minus);
                    ps.setInt(2,plus);
                    ps.setString(3,issuesId);
                    ps.executeUpdate();

                    setIssuesBooksTransaction();
                    setHistoryId();
                    setHistoriesTransaction();

                    issueStudentId.requestFocus(true);
                    issueBookID.setEnabled(true);

                }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (SQLException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setIssuesBooksTransaction(){
        String stdId=issuesStdId.getText();
        String stdName=issuesStdName.getText();
        String stdYS=issuesYS.getText();
        String book_date=issuesDate.getText();
        String book_due=issuesDueDate.getText();
        String issue="Issue Book";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("insert into db_transaction(studentId,name,yearSection, "
               + "bookId,title,author,category,action,date,duedate) values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,stdId);
            ps.setString(2,stdName);
            ps.setString(3,stdYS);
            ps.setString(4,issuesId);
            ps.setString(5,issuesTitle);
            ps.setString(6,issuesAuthor);
            ps.setString(7,issuesCategory);
            ps.setString(8,issue);
            ps.setString(9,book_date);
            ps.setString(10,book_due);
            ps.executeUpdate();

        }
        
        
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setHistoriesTransaction(){
        String stdId=issuesStdId.getText();
        String stdName=issuesStdName.getText();
        String stdYS=issuesYS.getText();
        String book_date=issuesDate.getText();
        String book_due=issuesDueDate.getText();
        String issue="Issue Book";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("insert into db_history(historyId,studentId,name,yearSection, "
               + "bookId,title,author,category,action,date,duedate) values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,historyId);
            ps.setString(2,stdId);
            ps.setString(3,stdName);
            ps.setString(4,stdYS);
            ps.setString(5,issuesId);
            ps.setString(6,issuesTitle);
            ps.setString(7,issuesAuthor);
            ps.setString(8,issuesCategory);
            ps.setString(9,issue);
            ps.setString(10,book_date);
            ps.setString(11,book_due);
            ps.executeUpdate();
        }
        
        
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    String workStatus;
    
    void setStatus(String status){
        date=new Date();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("insert into db_worklog(date,type,name,status) values(?,?,?,?)");
            ps.setString(1, format1.format(date));
            ps.setString(2, typeAcc);
            ps.setString(3, fullName);
            ps.setString(4, status);
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

        mainBody = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        logoName = new javax.swing.JLabel();
        logo1 = new javax.swing.JLabel();
        logo2 = new javax.swing.JLabel();
        sideNav = new javax.swing.JPanel();
        Pic = new javax.swing.JPanel();
        bgPic = new javax.swing.JLabel();
        sidenavBtn = new javax.swing.JPanel();
        dashboardBtn = new javax.swing.JPanel();
        homeIcon = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        bookListButton = new javax.swing.JPanel();
        menuIcon = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        transactionButton = new javax.swing.JPanel();
        menuIcon1 = new javax.swing.JLabel();
        menu1 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JPanel();
        logoutIcon = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        homePage = new javax.swing.JPanel();
        picContainer = new javax.swing.JLabel();
        descriptionBackground = new javax.swing.JPanel();
        description = new javax.swing.JLabel();
        titleDes = new javax.swing.JLabel();
        bgBlack = new javax.swing.JLabel();
        bookListPage = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        category = new javax.swing.JComboBox<>();
        txtFieldContainer = new javax.swing.JPanel();
        searchLogo = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        issueBookBtn = new javax.swing.JPanel();
        issueWindow = new javax.swing.JLabel();
        returnBookBtn = new javax.swing.JPanel();
        returnWindow = new javax.swing.JLabel();
        labelBookList = new javax.swing.JLabel();
        bgBlack4 = new javax.swing.JLabel();
        transactionPage = new javax.swing.JPanel();
        issueBox = new javax.swing.JPanel();
        descrip11 = new javax.swing.JLabel();
        logoBtn11 = new javax.swing.JLabel();
        pink3 = new javax.swing.JLabel();
        returnBox = new javax.swing.JPanel();
        descrip12 = new javax.swing.JLabel();
        logoBtn12 = new javax.swing.JLabel();
        green3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        bgBlack13 = new javax.swing.JLabel();
        issueBookPage = new javax.swing.JPanel();
        labelIssueBook = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        issueStudentName = new javax.swing.JTextField();
        issueYearSection = new javax.swing.JTextField();
        issueBookID = new javax.swing.JTextField();
        issueTitle = new javax.swing.JTextField();
        issueAuthor = new javax.swing.JTextField();
        issueCategory = new javax.swing.JTextField();
        issueDate = new javax.swing.JTextField();
        issueBookBtn1 = new javax.swing.JPanel();
        issueWindow1 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        issueStudentId = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        issueDueDate = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        bgBlack5 = new javax.swing.JLabel();
        returnBookPage = new javax.swing.JPanel();
        labelIssueBook1 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        year1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        returnStudentName = new javax.swing.JTextField();
        returnYearSection = new javax.swing.JTextField();
        returnBookID = new javax.swing.JTextField();
        returnTitle = new javax.swing.JTextField();
        returnAuthor = new javax.swing.JTextField();
        issuedDate = new javax.swing.JTextField();
        returnDate = new javax.swing.JTextField();
        returnBookBtn2 = new javax.swing.JPanel();
        returnWindow1 = new javax.swing.JLabel();
        back2 = new javax.swing.JLabel();
        id1 = new javax.swing.JLabel();
        returnStudentId = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        returnCategory = new javax.swing.JTextField();
        bgBlack6 = new javax.swing.JLabel();
        issueBooksPage = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        issueMultipleBooks = new javax.swing.JTable();
        id2 = new javax.swing.JLabel();
        back10 = new javax.swing.JLabel();
        issuesStdId = new javax.swing.JTextField();
        issuesStdName = new javax.swing.JTextField();
        name2 = new javax.swing.JLabel();
        year2 = new javax.swing.JLabel();
        issuesYS = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        issuesDate = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        issuesDueDate = new javax.swing.JTextField();
        issueBookBtn3 = new javax.swing.JPanel();
        issueWindow2 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        bgBlack17 = new javax.swing.JLabel();
        backgroundDesign = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/book_shelf_35px.png"))); // NOI18N
        logo.setText("`");
        logo.setFocusable(false);
        mainBody.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 35, 40));

        logoName.setFont(new java.awt.Font("Kartika", 0, 18)); // NOI18N
        logoName.setForeground(new java.awt.Color(255, 255, 255));
        logoName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoName.setText("CVSu-Library");
        mainBody.add(logoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 6, 120, 30));

        logo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/close_window_20px.png"))); // NOI18N
        logo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logo1.setFocusable(false);
        logo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logo1MousePressed(evt);
            }
        });
        mainBody.add(logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 9, 18, 18));

        logo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/minimize_window_20px.png"))); // NOI18N
        logo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logo2.setFocusable(false);
        logo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logo2MousePressed(evt);
            }
        });
        mainBody.add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 9, 18, 18));

        sideNav.setBackground(new java.awt.Color(153, 153, 153));
        sideNav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/book.png"))); // NOI18N
        bgPic.setFocusable(false);
        Pic.add(bgPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 180));

        sideNav.add(Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 198, 180));

        sidenavBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        sidenavBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboardBtn.setBackground(new java.awt.Color(134, 191, 230));
        dashboardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dashboardBtnMousePressed(evt);
            }
        });
        dashboardBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/home_30px.png"))); // NOI18N
        homeIcon.setFocusable(false);
        dashboardBtn.add(homeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        home.setFont(new java.awt.Font("Kartika", 1, 14)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setText("          DASHBOARD");
        home.setFocusable(false);
        home.setInheritsPopupMenu(false);
        dashboardBtn.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 198, 35));

        sidenavBtn.add(dashboardBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 198, 35));

        bookListButton.setBackground(new java.awt.Color(134, 191, 230));
        bookListButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookListButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookListButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookListButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bookListButtonMousePressed(evt);
            }
        });
        bookListButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/book_shelf_20px.png"))); // NOI18N
        menuIcon.setFocusable(false);
        bookListButton.add(menuIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        menu.setFont(new java.awt.Font("Kartika", 1, 14)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu.setText("     BOOKLIST");
        menu.setFocusable(false);
        bookListButton.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 198, 35));

        sidenavBtn.add(bookListButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 37, 198, 35));

        transactionButton.setBackground(new java.awt.Color(134, 191, 230));
        transactionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transactionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transactionButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transactionButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transactionButtonMousePressed(evt);
            }
        });
        transactionButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/transaction_list_25px.png"))); // NOI18N
        menuIcon1.setFocusable(false);
        transactionButton.add(menuIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        menu1.setFont(new java.awt.Font("Kartika", 1, 14)); // NOI18N
        menu1.setForeground(new java.awt.Color(255, 255, 255));
        menu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu1.setText("             TRANSACTION");
        menu1.setFocusable(false);
        transactionButton.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 198, 35));

        sidenavBtn.add(transactionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 72, 198, 35));

        logoutBtn.setBackground(new java.awt.Color(134, 191, 230));
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutBtnMousePressed(evt);
            }
        });
        logoutBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/exit_30px.png"))); // NOI18N
        logoutIcon.setFocusable(false);
        logoutBtn.add(logoutIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        logout.setFont(new java.awt.Font("Kartika", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("   LOG OUT");
        logout.setFocusable(false);
        logoutBtn.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 198, 35));

        sidenavBtn.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 107, 198, 35));

        sideNav.add(sidenavBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, -1, 145));

        mainBody.add(sideNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 198, 535));

        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        picContainer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picContainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/school/iLovecvsu.png"))); // NOI18N
        picContainer.setFocusable(false);
        homePage.add(picContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 30, 450, 330));

        descriptionBackground.setBackground(new java.awt.Color(248, 176, 154));
        descriptionBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        description.setFont(new java.awt.Font("Kartika", 0, 13)); // NOI18N
        description.setForeground(new java.awt.Color(255, 255, 255));
        description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        description.setText("<html><center>“WELCOME TO OUR LIBRARY HAVE FUN!!”<center> </html>");
        description.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        description.setFocusable(false);
        description.setRequestFocusEnabled(false);
        descriptionBackground.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 570, 110));

        titleDes.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        titleDes.setForeground(new java.awt.Color(255, 255, 255));
        titleDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDes.setText("<html><b>CVSU LIBRARY - BACOOR CITY CAMPUS</b></html>");
        titleDes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        descriptionBackground.add(titleDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 30));

        homePage.add(descriptionBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 360, 570, 140));

        bgBlack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        homePage.add(bgBlack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(homePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        bookListPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setWheelScrollingEnabled(false);

        bookTable.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Kasaysayan", "Ian Destura", "History", "Available", null},
                { new Integer(2), "Algebra", "Mica Mediado", "Math", "Available", null},
                { new Integer(3), "Biology", "Daina Masicampo", "Science", "Available", null},
                { new Integer(4), "Database", "Jonh Smith", "Computer", "Available", null},
                { new Integer(5), "Fitt", "Jason Iris Hilot", "Physical Education", "Available", null}
            },
            new String [] {
                "Book ID", "Title", "Author", "Category", "Available", "Borrowed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTable.setRowHeight(18);
        bookTable.setSelectionBackground(new java.awt.Color(249, 142, 138));
        bookTable.setShowVerticalLines(false);
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTable);

        bookListPage.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 140, 700, 310));

        category.setBackground(new java.awt.Color(248, 176, 154));
        category.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Mathematics", "English", "Science", "Filipino", "History", "Arts", "Physical Education", "Computer" }));
        category.setBorder(null);
        category.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        bookListPage.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 150, 25));

        txtFieldContainer.setBackground(new java.awt.Color(248, 176, 154));
        txtFieldContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/search_20px.png"))); // NOI18N
        txtFieldContainer.add(searchLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 30, 25));

        searchBar.setBackground(new java.awt.Color(248, 176, 154));
        searchBar.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        searchBar.setForeground(new java.awt.Color(255, 255, 255));
        searchBar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        searchBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        searchBar.setCaretColor(new java.awt.Color(255, 255, 255));
        txtFieldContainer.add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 25));

        bookListPage.add(txtFieldContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 180, 25));

        issueBookBtn.setBackground(new java.awt.Color(250, 120, 120));
        issueBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        issueBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueBookBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issueWindow.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueWindow.setForeground(new java.awt.Color(255, 255, 255));
        issueWindow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        issueWindow.setText("Issue");
        issueWindow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        issueWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                issueWindowMousePressed(evt);
            }
        });
        issueBookBtn.add(issueWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 28));

        bookListPage.add(issueBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 468, 80, 28));

        returnBookBtn.setBackground(new java.awt.Color(140, 140, 250));
        returnBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        returnBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnBookBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        returnWindow.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnWindow.setForeground(new java.awt.Color(255, 255, 255));
        returnWindow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        returnWindow.setText("Return");
        returnWindow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        returnWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                returnWindowMousePressed(evt);
            }
        });
        returnBookBtn.add(returnWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 28));

        bookListPage.add(returnBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 468, 80, 28));

        labelBookList.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        labelBookList.setForeground(new java.awt.Color(255, 255, 255));
        labelBookList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBookList.setText("Book List");
        bookListPage.add(labelBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 50, 250, -1));

        bgBlack4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        bookListPage.add(bgBlack4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(bookListPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        transactionPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issueBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                issueBoxMousePressed(evt);
            }
        });
        issueBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descrip11.setBackground(new java.awt.Color(0, 0, 0));
        descrip11.setFont(new java.awt.Font("Kartika", 1, 18)); // NOI18N
        descrip11.setForeground(new java.awt.Color(255, 255, 255));
        descrip11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descrip11.setText("ISSUE BOOK");
        descrip11.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        descrip11.setFocusable(false);
        issueBox.add(descrip11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 176, 30));

        logoBtn11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/travel_book_100px.png"))); // NOI18N
        issueBox.add(logoBtn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 90, 100));

        pink3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pink3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/orange.png"))); // NOI18N
        pink3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pink3.setFocusable(false);
        pink3.setPreferredSize(new java.awt.Dimension(180, 200));
        issueBox.add(pink3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        transactionPage.add(issueBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 180, 200));

        returnBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                returnBoxMousePressed(evt);
            }
        });
        returnBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descrip12.setBackground(new java.awt.Color(0, 0, 0));
        descrip12.setFont(new java.awt.Font("Kartika", 1, 18)); // NOI18N
        descrip12.setForeground(new java.awt.Color(255, 255, 255));
        descrip12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descrip12.setText("RETURN BOOK");
        descrip12.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        descrip12.setFocusable(false);
        returnBox.add(descrip12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 176, 30));

        logoBtn12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/return_book_100px.png"))); // NOI18N
        returnBox.add(logoBtn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 90, 100));

        green3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        green3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/aquamarine.png"))); // NOI18N
        green3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        green3.setFocusable(false);
        green3.setPreferredSize(new java.awt.Dimension(180, 200));
        returnBox.add(green3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        transactionPage.add(returnBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 180, 200));

        jLabel23.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Transaction");
        transactionPage.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 80, 250, -1));

        bgBlack13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        transactionPage.add(bgBlack13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(transactionPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        issueBookPage.setForeground(new java.awt.Color(255, 255, 255));
        issueBookPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIssueBook.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        labelIssueBook.setForeground(new java.awt.Color(255, 255, 255));
        labelIssueBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIssueBook.setText("Issue Book");
        issueBookPage.add(labelIssueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 35, 250, -1));

        name.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Student Name");
        issueBookPage.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        year.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        year.setForeground(new java.awt.Color(255, 255, 255));
        year.setText("Year & Section");
        issueBookPage.add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Book ID");
        issueBookPage.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Title");
        issueBookPage.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        jLabel11.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Author");
        issueBookPage.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        jLabel12.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Issue Date");
        issueBookPage.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, -1, -1));

        jLabel13.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Due Date");
        issueBookPage.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, -1, -1));

        issueStudentName.setBackground(new java.awt.Color(248, 176, 154));
        issueStudentName.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueStudentName.setForeground(new java.awt.Color(255, 255, 255));
        issueStudentName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueStudentName.setCaretColor(new java.awt.Color(255, 255, 255));
        issueStudentName.setEnabled(false);
        issueBookPage.add(issueStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 125, 200, 25));

        issueYearSection.setBackground(new java.awt.Color(248, 176, 154));
        issueYearSection.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueYearSection.setForeground(new java.awt.Color(255, 255, 255));
        issueYearSection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueYearSection.setCaretColor(new java.awt.Color(255, 255, 255));
        issueYearSection.setEnabled(false);
        issueBookPage.add(issueYearSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 165, 200, 25));

        issueBookID.setBackground(new java.awt.Color(248, 176, 154));
        issueBookID.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueBookID.setForeground(new java.awt.Color(255, 255, 255));
        issueBookID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueBookID.setCaretColor(new java.awt.Color(255, 255, 255));
        issueBookID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                issueBookIDKeyReleased(evt);
            }
        });
        issueBookPage.add(issueBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 205, 100, 25));

        issueTitle.setBackground(new java.awt.Color(248, 176, 154));
        issueTitle.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueTitle.setForeground(new java.awt.Color(255, 255, 255));
        issueTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueTitle.setCaretColor(new java.awt.Color(255, 255, 255));
        issueTitle.setEnabled(false);
        issueBookPage.add(issueTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 245, 250, 25));

        issueAuthor.setBackground(new java.awt.Color(248, 176, 154));
        issueAuthor.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueAuthor.setForeground(new java.awt.Color(255, 255, 255));
        issueAuthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueAuthor.setEnabled(false);
        issueBookPage.add(issueAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 285, 250, 25));

        issueCategory.setBackground(new java.awt.Color(248, 176, 154));
        issueCategory.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueCategory.setForeground(new java.awt.Color(255, 255, 255));
        issueCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueCategory.setCaretColor(new java.awt.Color(255, 255, 255));
        issueCategory.setEnabled(false);
        issueBookPage.add(issueCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 325, 250, 25));

        issueDate.setBackground(new java.awt.Color(248, 176, 154));
        issueDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueDate.setForeground(new java.awt.Color(255, 255, 255));
        issueDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueDate.setCaretColor(new java.awt.Color(255, 255, 255));
        issueDate.setEnabled(false);
        issueBookPage.add(issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 365, 100, 25));

        issueBookBtn1.setBackground(new java.awt.Color(250, 140, 140));
        issueBookBtn1.setForeground(new java.awt.Color(255, 255, 255));
        issueBookBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueBookBtn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issueWindow1.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueWindow1.setForeground(new java.awt.Color(255, 255, 255));
        issueWindow1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        issueWindow1.setText("Issue");
        issueWindow1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        issueWindow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                issueWindow1MousePressed(evt);
            }
        });
        issueBookBtn1.add(issueWindow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 25));

        issueBookPage.add(issueBookBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 80, 25));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backMousePressed(evt);
            }
        });
        issueBookPage.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        issueStudentId.setBackground(new java.awt.Color(248, 176, 154));
        issueStudentId.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueStudentId.setForeground(new java.awt.Color(255, 255, 255));
        issueStudentId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueStudentId.setCaretColor(new java.awt.Color(255, 255, 255));
        issueStudentId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                issueStudentIdKeyReleased(evt);
            }
        });
        issueBookPage.add(issueStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 85, 200, 25));

        id.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("Student ID");
        issueBookPage.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        issueDueDate.setBackground(new java.awt.Color(248, 176, 154));
        issueDueDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueDueDate.setForeground(new java.awt.Color(255, 255, 255));
        issueDueDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueDueDate.setCaretColor(new java.awt.Color(255, 255, 255));
        issueDueDate.setEnabled(false);
        issueBookPage.add(issueDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 405, 100, 25));

        jLabel37.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Category");
        issueBookPage.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        bgBlack5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        issueBookPage.add(bgBlack5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(issueBookPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        returnBookPage.setForeground(new java.awt.Color(255, 255, 255));
        returnBookPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIssueBook1.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        labelIssueBook1.setForeground(new java.awt.Color(255, 255, 255));
        labelIssueBook1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIssueBook1.setText("Return Book");
        returnBookPage.add(labelIssueBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 35, 250, -1));

        name1.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        name1.setForeground(new java.awt.Color(255, 255, 255));
        name1.setText("Student Name");
        returnBookPage.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        year1.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        year1.setForeground(new java.awt.Color(255, 255, 255));
        year1.setText("Grade & Section");
        returnBookPage.add(year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jLabel16.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Book ID");
        returnBookPage.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        jLabel17.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Title");
        returnBookPage.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        jLabel18.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Author");
        returnBookPage.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        jLabel19.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Issued Date");
        returnBookPage.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, -1, -1));

        jLabel20.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Return Date");
        returnBookPage.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, -1, -1));

        returnStudentName.setBackground(new java.awt.Color(248, 176, 154));
        returnStudentName.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnStudentName.setForeground(new java.awt.Color(255, 255, 255));
        returnStudentName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnStudentName.setCaretColor(new java.awt.Color(255, 255, 255));
        returnBookPage.add(returnStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 125, 200, 25));

        returnYearSection.setBackground(new java.awt.Color(248, 176, 154));
        returnYearSection.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnYearSection.setForeground(new java.awt.Color(255, 255, 255));
        returnYearSection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnYearSection.setCaretColor(new java.awt.Color(255, 255, 255));
        returnBookPage.add(returnYearSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 165, 200, 25));

        returnBookID.setBackground(new java.awt.Color(248, 176, 154));
        returnBookID.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnBookID.setForeground(new java.awt.Color(255, 255, 255));
        returnBookID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnBookID.setCaretColor(new java.awt.Color(255, 255, 255));
        returnBookID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                returnBookIDKeyReleased(evt);
            }
        });
        returnBookPage.add(returnBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 205, 100, 25));

        returnTitle.setBackground(new java.awt.Color(248, 176, 154));
        returnTitle.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnTitle.setForeground(new java.awt.Color(255, 255, 255));
        returnTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnTitle.setCaretColor(new java.awt.Color(255, 255, 255));
        returnTitle.setEnabled(false);
        returnBookPage.add(returnTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 245, 250, 25));

        returnAuthor.setBackground(new java.awt.Color(248, 176, 154));
        returnAuthor.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnAuthor.setForeground(new java.awt.Color(255, 255, 255));
        returnAuthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnAuthor.setEnabled(false);
        returnBookPage.add(returnAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 285, 250, 25));

        issuedDate.setBackground(new java.awt.Color(248, 176, 154));
        issuedDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issuedDate.setForeground(new java.awt.Color(255, 255, 255));
        issuedDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issuedDate.setCaretColor(new java.awt.Color(255, 255, 255));
        issuedDate.setEnabled(false);
        returnBookPage.add(issuedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 365, 100, 25));

        returnDate.setBackground(new java.awt.Color(248, 176, 154));
        returnDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnDate.setForeground(new java.awt.Color(255, 255, 255));
        returnDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnDate.setCaretColor(new java.awt.Color(255, 255, 255));
        returnDate.setEnabled(false);
        returnBookPage.add(returnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 405, 100, 25));

        returnBookBtn2.setBackground(new java.awt.Color(140, 140, 250));
        returnBookBtn2.setForeground(new java.awt.Color(255, 255, 255));
        returnBookBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnBookBtn2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        returnWindow1.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnWindow1.setForeground(new java.awt.Color(255, 255, 255));
        returnWindow1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        returnWindow1.setText("Return");
        returnWindow1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        returnWindow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                returnWindow1MousePressed(evt);
            }
        });
        returnBookBtn2.add(returnWindow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 25));

        returnBookPage.add(returnBookBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 80, 25));

        back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back2MousePressed(evt);
            }
        });
        returnBookPage.add(back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        id1.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        id1.setForeground(new java.awt.Color(255, 255, 255));
        id1.setText("Student ID");
        returnBookPage.add(id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        returnStudentId.setBackground(new java.awt.Color(248, 176, 154));
        returnStudentId.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnStudentId.setForeground(new java.awt.Color(255, 255, 255));
        returnStudentId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnStudentId.setCaretColor(new java.awt.Color(255, 255, 255));
        returnStudentId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                returnStudentIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                returnStudentIdKeyTyped(evt);
            }
        });
        returnBookPage.add(returnStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 85, 200, 25));

        jLabel38.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Category");
        returnBookPage.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        returnCategory.setBackground(new java.awt.Color(248, 176, 154));
        returnCategory.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnCategory.setForeground(new java.awt.Color(255, 255, 255));
        returnCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnCategory.setEnabled(false);
        returnBookPage.add(returnCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 325, 250, 25));

        bgBlack6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        returnBookPage.add(bgBlack6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(returnBookPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        issueBooksPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Issue Book");
        issueBooksPage.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 400, 30));

        issueMultipleBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Author", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issueMultipleBooks.setSelectionBackground(new java.awt.Color(249, 142, 138));
        jScrollPane7.setViewportView(issueMultipleBooks);

        issueBooksPage.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 500, 390));

        id2.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        id2.setForeground(new java.awt.Color(255, 255, 255));
        id2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id2.setText("Student ID");
        issueBooksPage.add(id2, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 130, 180, -1));

        back10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back10MousePressed(evt);
            }
        });
        issueBooksPage.add(back10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        issuesStdId.setBackground(new java.awt.Color(248, 176, 154));
        issuesStdId.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issuesStdId.setForeground(new java.awt.Color(255, 255, 255));
        issuesStdId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        issuesStdId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issuesStdId.setCaretColor(new java.awt.Color(255, 255, 255));
        issuesStdId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        issueBooksPage.add(issuesStdId, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 155, 180, 25));

        issuesStdName.setBackground(new java.awt.Color(248, 176, 154));
        issuesStdName.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issuesStdName.setForeground(new java.awt.Color(255, 255, 255));
        issuesStdName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        issuesStdName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issuesStdName.setCaretColor(new java.awt.Color(255, 255, 255));
        issuesStdName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        issueBooksPage.add(issuesStdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 220, 180, 25));

        name2.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        name2.setForeground(new java.awt.Color(255, 255, 255));
        name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name2.setText("Student Name");
        issueBooksPage.add(name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 195, 180, -1));

        year2.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        year2.setForeground(new java.awt.Color(255, 255, 255));
        year2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year2.setText("Year & Section");
        issueBooksPage.add(year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 260, 180, -1));

        issuesYS.setBackground(new java.awt.Color(248, 176, 154));
        issuesYS.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issuesYS.setForeground(new java.awt.Color(255, 255, 255));
        issuesYS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        issuesYS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issuesYS.setCaretColor(new java.awt.Color(255, 255, 255));
        issuesYS.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        issueBooksPage.add(issuesYS, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 285, 180, 25));

        jLabel93.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Issue Date");
        issueBooksPage.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 325, 180, -1));

        issuesDate.setBackground(new java.awt.Color(248, 176, 154));
        issuesDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issuesDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        issuesDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issuesDate.setEnabled(false);
        issueBooksPage.add(issuesDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 350, 180, 25));

        jLabel94.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("Return Date");
        issueBooksPage.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 390, 180, -1));

        issuesDueDate.setBackground(new java.awt.Color(248, 176, 154));
        issuesDueDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issuesDueDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        issuesDueDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issuesDueDate.setEnabled(false);
        issueBooksPage.add(issuesDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 415, 180, 25));

        issueBookBtn3.setBackground(new java.awt.Color(250, 140, 140));
        issueBookBtn3.setForeground(new java.awt.Color(255, 255, 255));
        issueBookBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueBookBtn3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issueWindow2.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueWindow2.setForeground(new java.awt.Color(255, 255, 255));
        issueWindow2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        issueWindow2.setText("Issue");
        issueWindow2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        issueWindow2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                issueWindow2MousePressed(evt);
            }
        });
        issueBookBtn3.add(issueWindow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 28));

        issueBooksPage.add(issueBookBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 455, 80, 28));

        jLabel79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        issueBooksPage.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 210, 387));

        bgBlack17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        issueBooksPage.add(bgBlack17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(issueBooksPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        mainBody.add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 755, 515));

        backgroundDesign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.jpg"))); // NOI18N
        backgroundDesign.setFocusable(false);
        mainBody.add(backgroundDesign, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(mainBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnMouseEntered
        if(homePage.isVisible()==true&&homePage.isEnabled()==true){
            setBtnHover(dashboardBtn, 249, 142, 138);
        }
        else if(bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
            transactionPage.isVisible()==true&&transactionPage.isEnabled()==true){
            setBtnHover(dashboardBtn, 249, 142, 138);
        }
    }//GEN-LAST:event_dashboardBtnMouseEntered

    private void dashboardBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnMouseExited
        if(homePage.isVisible()==true&&homePage.isEnabled()==true){
            setBtnHover(dashboardBtn, 249, 142, 138);
        }
        else if(bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
            transactionPage.isVisible()==true&&transactionPage.isEnabled()==true){
            setBtnHover(dashboardBtn, 134, 191, 230);
        }
    }//GEN-LAST:event_dashboardBtnMouseExited

    private void dashboardBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,issueBooksPage,transactionPage,false);
        setActive(dashboardBtn,homePage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
    }//GEN-LAST:event_dashboardBtnMousePressed

    private void bookListButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookListButtonMouseEntered
        if(bookListPage.isVisible()==true&&bookListPage.isEnabled()==true){
            setBtnHover(bookListButton, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
            transactionPage.isVisible()==true&&transactionPage.isEnabled()==true){
            setBtnHover(bookListButton, 249, 142, 138);
        }
    }//GEN-LAST:event_bookListButtonMouseEntered

    private void bookListButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookListButtonMouseExited
        if(bookListPage.isVisible()==true&&bookListPage.isEnabled()==true){
            setBtnHover(bookListButton, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
            transactionPage.isVisible()==true&&transactionPage.isEnabled()==true){
            setBtnHover(bookListButton, 134, 191, 230);
        }
    }//GEN-LAST:event_bookListButtonMouseExited

    private void bookListButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookListButtonMousePressed
        hidePanelGroup(homePage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,issueBooksPage,homePage,false);
        
        setActive(bookListButton,bookListPage);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        
        category.setSelectedIndex(0);
        setBookList();
        select=-1;
        
    }//GEN-LAST:event_bookListButtonMousePressed

    private void transactionButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionButtonMouseEntered
        if(transactionPage.isVisible()==true&&transactionPage.isEnabled()==true){
            setBtnHover(transactionButton, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
            bookListPage.isVisible()==true&&bookListPage.isEnabled()==true){
            setBtnHover(transactionButton, 249, 142, 138);
        }
    }//GEN-LAST:event_transactionButtonMouseEntered

    private void transactionButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionButtonMouseExited
        if(transactionPage.isVisible()==true&&transactionPage.isEnabled()==true){
            setBtnHover(transactionButton, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
            bookListPage.isVisible()==true&&bookListPage.isEnabled()==true){
            setBtnHover(transactionButton, 134, 191, 230);
        }
    }//GEN-LAST:event_transactionButtonMouseExited

    private void transactionButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionButtonMousePressed
        hidePanelGroup(bookListPage,homePage,issueBookPage,false);
        hidePanelGroup(returnBookPage,issueBooksPage,bookListPage,false);
        
        setActive(transactionButton,transactionPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        
    }//GEN-LAST:event_transactionButtonMousePressed

    private void logoutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseEntered
        setBtnHover(logoutBtn, 249, 142, 138);
    }//GEN-LAST:event_logoutBtnMouseEntered

    private void logoutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseExited
        setBtnHover(logoutBtn, 134, 191, 230);
    }//GEN-LAST:event_logoutBtnMouseExited

    private void logoutBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMousePressed
        workStatus="Log Out";
        setStatus(workStatus);
        new login404().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnMousePressed

    private void issueBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueBoxMousePressed
        String typeUser=JOptionPane.showInputDialog(null,"Please select one: \n 1. Student \n 2. Teacher \n 3. Exit" ,"Message",3);
        numChoice=typeUser;
        
        if(typeUser.equals("1")){
            setIssuePanel(transactionButton,bookListButton,issueBookPage);
            exit=3;
            issueBookID.setEnabled(true);
            issueBookID.setText("");
            issueTitle.setText("");
            issueAuthor.setText("");
            issueCategory.setText("");
            id.setText("Student ID");
            name.setText("Student Name");
            year.setText("Year & Section");
            if(issueStudentId.getText().isEmpty()||issueStudentName.getText().isEmpty()||
                issueYearSection.getText().isEmpty()||issueBookID.getText().isEmpty()||
                issueTitle.getText().isEmpty()||issueAuthor.getText().isEmpty()||
                issueCategory.getText().isEmpty()||issueDate.getText().isEmpty()||
                issueDueDate.getText().isEmpty()){

                issueDate.setText("");
                issueDueDate.setText("");
            }
        }
        else if(typeUser.equals("2")){
            setIssuePanel(transactionButton,bookListButton,issueBookPage);
            exit=3;
            issueBookID.setEnabled(true);
            issueBookID.setText("");
            issueTitle.setText("");
            issueAuthor.setText("");
            issueCategory.setText("");
            id.setText("Teacher ID");
            name.setText("Teacher Name");
            year.setText("Department");
            if(issueStudentId.getText().isEmpty()||issueStudentName.getText().isEmpty()||
                issueYearSection.getText().isEmpty()||issueBookID.getText().isEmpty()||
                issueTitle.getText().isEmpty()||issueAuthor.getText().isEmpty()||
                issueCategory.getText().isEmpty()||issueDate.getText().isEmpty()||
                issueDueDate.getText().isEmpty()){

                issueDate.setText("");
                issueDueDate.setText("");
            }
        }

    }//GEN-LAST:event_issueBoxMousePressed

    private void returnBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBoxMousePressed
        String typeUser=JOptionPane.showInputDialog(null,"Please select one: \n 1. Student \n 2. Teacher \n 3. Exit" ,"Message",3);

        if(typeUser.equals("1")){
            setReturnPanel(transactionButton,bookListButton);
            exit=4;
            returnStudentName.setEnabled(false);
            returnYearSection.setEnabled(false);
            returnStudentId.setText("");
            returnStudentName.setText("");
            returnYearSection.setText("");
            returnBookID.setEnabled(true);
            returnBookID.setText("");
            returnTitle.setText("");
            returnAuthor.setText("");
            returnCategory.setText("");
            returnDate.setText("");
            issuedDate.setText("");
            id1.setText("Student ID");
            name1.setText("Student Name");
            year1.setText("Year & Section");
        }
        else if(typeUser.equals("2")){
            setReturnPanel(transactionButton,bookListButton);
            exit=4;
            returnStudentName.setEnabled(false);
            returnYearSection.setEnabled(false);
            returnStudentId.setText("");
            returnStudentName.setText("");
            returnYearSection.setText("");
            returnBookID.setEnabled(true);
            returnBookID.setText("");
            returnTitle.setText("");
            returnAuthor.setText("");
            returnCategory.setText("");
            returnDate.setText("");
            issuedDate.setText("");
            id1.setText("Teacher ID");
            name1.setText("Teacher Name");
            year1.setText("Department");
        }

    }//GEN-LAST:event_returnBoxMousePressed

    private void issueBookIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_issueBookIDKeyReleased
        String getID=issueBookID.getText();
        date=new Date();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("select * from db_booklist where bookId like '%"+getID+"%' ");
            rs=ps.executeQuery();

            if(rs.next()){
                int isAvailable=rs.getInt("returnBook");
                String bookIdentify=rs.getString("bookId");
                if(issueBookID.getText().length()>5||issueBookID.getText().length()<5){
                    issueTitle.setText("");
                    issueAuthor.setText("");
                    issueCategory.setText("");
                    issueDate.setText("");
                    issueDueDate.setText("");
                }
                else if(isAvailable==0){
                    JOptionPane.showMessageDialog(null,"This book is already borrowed","Error",0);
                    issueBookID.setText("");
                }
                else{
                    issueTitle.setText(rs.getString("title"));
                    issueAuthor.setText(rs.getString("author"));
                    issueCategory.setText(rs.getString("category"));

                    issueDate.setText(format.format(date));
                    long days=setNextDate(date); 
                    issueDueDate.setText(format.format(days));
                    quantity=rs.getInt("returnBook"); 
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"This type of Book ID is not existed","Error",0);
                issueBookID.setText("");
                issueTitle.setText("");
                issueAuthor.setText("");
                issueCategory.setText("");
                issueDate.setText("");
                issueDueDate.setText("");
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_issueBookIDKeyReleased

    private void issueWindow1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueWindow1MousePressed
        date=new Date();
        if(issueStudentId.getText().isEmpty()||issueStudentName.getText().isEmpty()||
            issueYearSection.getText().isEmpty()||issueBookID.getText().isEmpty()||
            issueTitle.getText().isEmpty()||issueAuthor.getText().isEmpty()||
            issueCategory.getText().isEmpty()||issueDate.getText().isEmpty()||
            issueDueDate.getText().isEmpty()){

            JOptionPane.showMessageDialog(null,"Please all information needed","Error",0);
        }
        else{
            int minus=quantity-1; 
            int plus=issuedBook+1; 
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("update db_booklist set returnBook=?, issueBook=? where bookId=?");
                ps.setInt(1,minus);
                ps.setInt(2,plus);
                ps.setString(3,issueBookID.getText());
                ps.executeUpdate();

                setIssueTransaction();
                setHistoryId();
                setHistoryTransaction();

                issueStudentId.requestFocus(true);
                issueBookID.setEnabled(true);
                
                workStatus="Issue Book";
                setStatus(workStatus);
                JOptionPane.showMessageDialog(null,"Issued book sucessful","Message",1);
            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_issueWindow1MousePressed

    private void backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMousePressed
        setBackArrow(); 
    }//GEN-LAST:event_backMousePressed

    private void returnBookIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnBookIDKeyReleased
        String getID=returnBookID.getText();
        date=new Date();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("select * from db_booklist where bookId like '%"+getID+"%' ");
            rs=ps.executeQuery();

            if(rs.next()){
                quantity=rs.getInt("returnBook");
                borrowQuan=rs.getInt("issueBook"); 
                int isAvailable=rs.getInt("issueBook");

                if(returnBookID.getText().length()>5||returnBookID.getText().length()<5){
                    returnStudentId.setText("");
                    returnStudentName.setText("");
                    returnYearSection.setText("");
                    returnTitle.setText("");
                    returnAuthor.setText("");
                    returnCategory.setText("");
                    issuedDate.setText("");
                    returnDate.setText("");
                }
                else if(isAvailable==0){
                    JOptionPane.showMessageDialog(null,"This book is already returned","Error",0);
                    returnBookID.setText("");
                }
                else{
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                        ps=conn.prepareStatement("select * from db_transaction where bookId like '%"+getID+"%' ");
                        rs=ps.executeQuery();

                        if(rs.next()){
                            returnTitle.setText(rs.getString("title"));
                            returnAuthor.setText(rs.getString("author"));
                            returnCategory.setText(rs.getString("category"));
                            issuedDate.setText(rs.getString("date"));
                            returnDate.setText(format.format(date));

                        }

                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else{
                returnStudentId.setText("");
                returnStudentName.setText("");
                returnYearSection.setText("");
                returnTitle.setText("");
                returnAuthor.setText("");
                returnCategory.setText("");
                issuedDate.setText("");
                returnDate.setText("");
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_returnBookIDKeyReleased

    private void returnWindow1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnWindow1MousePressed
        date=new Date();
        
        if(returnStudentId.getText().isEmpty()||returnStudentName.getText().isEmpty()||
            returnYearSection.getText().isEmpty()||returnBookID.getText().isEmpty()||
            returnTitle.getText().isEmpty()||returnAuthor.getText().isEmpty()||
            returnCategory.getText().isEmpty()||issuedDate.getText().isEmpty()||
            returnDate.getText().isEmpty()){

            JOptionPane.showMessageDialog(null,"Please all information needed","Error",0);

        }
        else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select * from db_transaction where bookId=? and name=?");
                ps.setString(1,returnBookID.getText());
                ps.setString(2,returnStudentName.getText());

                rs=ps.executeQuery();

                if(rs.next()){
                    setDeletingBooks(); 
                    workStatus="Return Book";
                    setStatus(workStatus);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Book is not been borrowed or Incorrect Name User","Erorr",0);
                }
            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_returnWindow1MousePressed

    private void back2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back2MousePressed
        setBackArrow(); 
    }//GEN-LAST:event_back2MousePressed

    private void returnStudentIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnStudentIdKeyReleased
        String getStdID=returnStudentId.getText();
        if(numChoice.equals("1")){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select * from db_transaction where studentId=? and bookId=?");
                ps.setString(1,returnStudentId.getText());
                ps.setString(2,returnBookID.getText());
                rs=ps.executeQuery();

                if(rs.next()){
                    returnStudentId.setText(rs.getString("studentId"));
                    returnStudentName.setText(rs.getString("name"));
                    returnYearSection.setText(rs.getString("yearSection"));
                }
                else{
                    if(returnStudentId.getText().length()==10){
                        JOptionPane.showMessageDialog(null,"This Student ID is not register as the borrower of this book!","Error",0);
                        returnStudentName.setText("");
                        returnYearSection.setText("");
                    }
                }
            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_returnStudentIdKeyReleased

    private void returnStudentIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnStudentIdKeyTyped
        if(evt.getKeyChar()==evt.VK_BACK_SPACE){
            returnStudentName.setText("");
            returnYearSection.setText("");
        }
    }//GEN-LAST:event_returnStudentIdKeyTyped

    private void back10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back10MousePressed
        setBackArrow();
    }//GEN-LAST:event_back10MousePressed

    private void issueWindow2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueWindow2MousePressed
        if(issuesStdId.getText().isEmpty()||issuesStdId.getText().isEmpty()||issuesYS.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Fill all information needed","Error",0);
            issuesStdId.setText("");
            issuesStdId.setText("");
            issuesYS.setText("");
        }
        else{
            DefaultTableModel model=(DefaultTableModel)issueMultipleBooks.getModel();
            int rowCounts=issueMultipleBooks.getRowCount();

            String[] getRow=new String[rowCounts];

            for(int i=0;i<rowCounts;i++){
                getRow[i]=model.getValueAt(i,0).toString();
                getIssuedBooks(getRow[i]);
            }
            
            DefaultTableModel model1=(DefaultTableModel)issueMultipleBooks.getModel();
            model1.setRowCount(0);
            issueMultipleBooks.setModel(model1);
            issuesStdId.setText("");
            issuesStdId.setText("");
            issuesYS.setText("");    
            
            workStatus="Issue Book";
            setStatus(workStatus);
            
            JOptionPane.showMessageDialog(null,"Issued book sucessful","Message",1);
        }


    }//GEN-LAST:event_issueWindow2MousePressed

    private void returnWindowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnWindowMousePressed
        exit=2;
        date=new Date();
        //        quantity=Integer.parseInt(state);
        if(select==-1){
            JOptionPane.showMessageDialog(null, "Please select atleast one book!","Error",0);
            setBookList();
            select=-1;
        }
        else if(borrowQuan==0){
            JOptionPane.showMessageDialog(null, "The book is already returned","Error",1);
            setBookList();
            select=-1;
        }
        else if(borrowQuan>0){
            String typeUser=JOptionPane.showInputDialog(null,"Please select one: \n 1. Student \n 2. Teacher \n 3. Exit" ,"Message",3);
            numChoice=typeUser;
            
            if(typeUser.equals("1")){
                getReturnTransaction();

                setReturnPanel(bookListButton,transactionButton);
                returnBookID.setEnabled(false);
                returnStudentName.setEnabled(false);
                returnYearSection.setEnabled(false);
                id1.setText("Student ID");
                name1.setText("Student Name");
                year1.setText("Year & Section");
                returnStudentId.setText("");
                returnStudentName.setText("");
                returnStudentId.setText("");
                returnDate.setText(format.format(date));
            }
            else if(typeUser.equals("2")){
                getReturnTransaction();

                setReturnPanel(bookListButton,transactionButton);
                returnBookID.setEnabled(false);
                returnStudentName.setEnabled(false);
                returnYearSection.setEnabled(false);
                id1.setText("Teacher ID");
                name1.setText("Teacher Name");
                year1.setText("Department");
                returnStudentId.setText("");
                returnStudentName.setText("");
                returnStudentId.setText("");
                returnDate.setText(format.format(date));
            }

        }
    }//GEN-LAST:event_returnWindowMousePressed

    String numChoice;
    
    private void issueWindowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueWindowMousePressed
        exit=1;
        date=new Date();
        
        if(select==-1){
            JOptionPane.showMessageDialog(null, "Please select atleast one book!","Error",0);
            setBookList();
            select=-1;
        }
        
        else if(lengths==1&&quantity==0){
            JOptionPane.showMessageDialog(null, "The book is already borrowed","Error",1);
            setBookList();
            select=-1;
        }
        else if(lengths==1&&quantity>=1){
            String typeUser=JOptionPane.showInputDialog(null,"Please select one: \n 1. Student \n 2. Teacher \n 3. Exit" ,"Message",3); 
            numChoice=typeUser;
            
            if(typeUser.equals("1")){
                setIssuePanel(bookListButton,transactionButton,issueBookPage);
                issueBookID.setEnabled(false);
                id.setText("Student Id");
                name.setText("Student Name");
                year.setText("Year & Section");
                issueStudentId.setText("");
                issueStudentName.setText("");
                issueYearSection.setText("");
                setSelectIssue();
            }
            else if(typeUser.equals("2")){
                setIssuePanel(bookListButton,transactionButton,issueBookPage);
                issueBookID.setEnabled(false);
                id.setText("Teacher ID");
                name.setText("Teacher Name");
                year.setText("Department");
                issueStudentId.setText("");
                issueStudentName.setText("");
                issueYearSection.setText("");
                setSelectIssue();
            }
            else if(!typeUser.equals("3")||!typeUser.equals("2")||!typeUser.equals("1")){
                JOptionPane.showMessageDialog(null, "Incorrect Choice!","Error",0);
                setBookList();
                select=-1;
            }
            
        }
        
        else if((lengths==2||lengths==3)&&bookAvail!=1){
            String typeUser=JOptionPane.showInputDialog(null,"Please select one: \n 1. Student \n 2. Teacher \n 3. Exit" ,"Message",3); 

            if(typeUser.equals("1")){
                setIssuesPanel(bookListButton,transactionButton,issueBooksPage);
                id2.setText("Student Id");
                name2.setText("Student Name");
                year2.setText("Year & Section");
                issuesDate.setText(format.format(date)); 
                long days=setNextDate(date); 
                issuesDueDate.setText(format.format(days));
            }
            else if(typeUser.equals("2")){
                setIssuesPanel(bookListButton,transactionButton,issueBooksPage);
                id2.setText("Teacher ID");
                name2.setText("Teacher Name");
                year2.setText("Department");
                issuesDate.setText(format.format(date)); 
                long days=setNextDate(date); 
                issuesDueDate.setText(format.format(days));
            }
            else if(!typeUser.equals("3")||!typeUser.equals("2")||!typeUser.equals("1")){
                JOptionPane.showMessageDialog(null, "Incorrect Choice!","Error",0);
                setBookList();
                select=-1;
            }
        }
        
        else if(lengths>=4){
            JOptionPane.showMessageDialog(null, "You must select atleast maximum of three books","Error",1);
            setBookList();
            select=-1;
        }
        
        else if(bookAvail==1){
            JOptionPane.showMessageDialog(null, "Either one of the book you select is cannot be borrowed!\nPlease cheak it wisely!","Error",1);
            setBookList();
            select=-1;
            bookAvail=0;
        }
        
    }//GEN-LAST:event_issueWindowMousePressed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        bookCategories=(String)category.getSelectedItem(); 
        search=searchBar.getText();  

        if(bookCategories.equals("Select Category")){
            setBookList();
            searchBar.setText("");
        }
        else{
            setBookCategory(bookCategories); 
            searchBar.setText("");

        }
    }//GEN-LAST:event_categoryActionPerformed

    int bookAvail;
    private void bookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTableMouseClicked

        DefaultTableModel model=(DefaultTableModel)bookTable.getModel();
        select=bookTable.getSelectedRow();
        int[] selects=bookTable.getSelectedRows();
        
        lengths=selects.length;
        bookIDS=model.getValueAt(select,0).toString();
        state=model.getValueAt(select,4).toString();
        borrowed=model.getValueAt(select,5).toString();
        
        quantity=Integer.parseInt(state);
        borrowQuan=Integer.parseInt(borrowed); 

        Object[] row=new Object[5];
        
        DefaultTableModel model1=(DefaultTableModel)issueMultipleBooks.getModel();
        model1.setRowCount(0);
        issueMultipleBooks.setModel(model1);
        
        for(int i=0;i<selects.length;i++){
            row[0]=model.getValueAt(selects[i],0);
            row[1]=model.getValueAt(selects[i],1);
            row[2]=model.getValueAt(selects[i],2);
            row[3]=model.getValueAt(selects[i],3);
            
            model1.addRow(row);
            row[4]=model.getValueAt(selects[i],4);
            quantity=Integer.parseInt(row[4].toString());
            if(quantity==0){
                bookAvail=1;
            }
            else if(quantity>=1){
                bookAvail=0;
            }
            
        }
    }//GEN-LAST:event_bookTableMouseClicked

    private void logo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo1MousePressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_logo1MousePressed

    private void logo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo2MousePressed
        this.setExtendedState(librarian.ICONIFIED);
    }//GEN-LAST:event_logo2MousePressed

    private void issueStudentIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_issueStudentIdKeyReleased
        
        if(numChoice.equals("1")){
            String getID=issueStudentId.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select * from db_libraryusers where studentNO like '%"+getID+"%' ");
                rs=ps.executeQuery();

                if(rs.next()){
                    if(issueStudentId.getText().length()>10||issueStudentId.getText().length()<10){
                        issueStudentName.setText("");
                        issueYearSection.setText("");
                    }
                    else{
                        issueStudentName.setText(rs.getString("name"));
                        issueYearSection.setText(rs.getString("section"));
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"This student number is not existed","Error",0);
                }
            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_issueStudentIdKeyReleased

    
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
            java.util.logging.Logger.getLogger(librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new librarian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pic;
    private javax.swing.JLabel back;
    private javax.swing.JLabel back10;
    private javax.swing.JLabel back2;
    private javax.swing.JLabel backgroundDesign;
    private javax.swing.JLabel bgBlack;
    private javax.swing.JLabel bgBlack13;
    private javax.swing.JLabel bgBlack17;
    private javax.swing.JLabel bgBlack4;
    private javax.swing.JLabel bgBlack5;
    private javax.swing.JLabel bgBlack6;
    private javax.swing.JLabel bgPic;
    private javax.swing.JPanel body;
    private javax.swing.JPanel bookListButton;
    private javax.swing.JPanel bookListPage;
    private javax.swing.JTable bookTable;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JPanel dashboardBtn;
    private javax.swing.JLabel descrip11;
    private javax.swing.JLabel descrip12;
    private javax.swing.JLabel description;
    private javax.swing.JPanel descriptionBackground;
    private javax.swing.JLabel green3;
    private javax.swing.JLabel home;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JPanel homePage;
    private javax.swing.JLabel id;
    private javax.swing.JLabel id1;
    private javax.swing.JLabel id2;
    private javax.swing.JTextField issueAuthor;
    private javax.swing.JPanel issueBookBtn;
    private javax.swing.JPanel issueBookBtn1;
    private javax.swing.JPanel issueBookBtn3;
    private javax.swing.JTextField issueBookID;
    private javax.swing.JPanel issueBookPage;
    private javax.swing.JPanel issueBooksPage;
    private javax.swing.JPanel issueBox;
    private javax.swing.JTextField issueCategory;
    private javax.swing.JTextField issueDate;
    private javax.swing.JTextField issueDueDate;
    private javax.swing.JTable issueMultipleBooks;
    private javax.swing.JTextField issueStudentId;
    private javax.swing.JTextField issueStudentName;
    private javax.swing.JTextField issueTitle;
    private javax.swing.JLabel issueWindow;
    private javax.swing.JLabel issueWindow1;
    private javax.swing.JLabel issueWindow2;
    private javax.swing.JTextField issueYearSection;
    private javax.swing.JTextField issuedDate;
    private javax.swing.JTextField issuesDate;
    private javax.swing.JTextField issuesDueDate;
    private javax.swing.JTextField issuesStdId;
    private javax.swing.JTextField issuesStdName;
    private javax.swing.JTextField issuesYS;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel labelBookList;
    private javax.swing.JLabel labelIssueBook;
    private javax.swing.JLabel labelIssueBook1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo1;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel logoBtn11;
    private javax.swing.JLabel logoBtn12;
    private javax.swing.JLabel logoName;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel logoutBtn;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JPanel mainBody;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel menu1;
    private javax.swing.JLabel menuIcon;
    private javax.swing.JLabel menuIcon1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel picContainer;
    private javax.swing.JLabel pink3;
    private javax.swing.JTextField returnAuthor;
    private javax.swing.JPanel returnBookBtn;
    private javax.swing.JPanel returnBookBtn2;
    private javax.swing.JTextField returnBookID;
    private javax.swing.JPanel returnBookPage;
    private javax.swing.JPanel returnBox;
    private javax.swing.JTextField returnCategory;
    private javax.swing.JTextField returnDate;
    private javax.swing.JTextField returnStudentId;
    private javax.swing.JTextField returnStudentName;
    private javax.swing.JTextField returnTitle;
    private javax.swing.JLabel returnWindow;
    private javax.swing.JLabel returnWindow1;
    private javax.swing.JTextField returnYearSection;
    private javax.swing.JTextField searchBar;
    private javax.swing.JLabel searchLogo;
    private javax.swing.JPanel sideNav;
    private javax.swing.JPanel sidenavBtn;
    private javax.swing.JLabel titleDes;
    private javax.swing.JPanel transactionButton;
    private javax.swing.JPanel transactionPage;
    private javax.swing.JPanel txtFieldContainer;
    private javax.swing.JLabel year;
    private javax.swing.JLabel year1;
    private javax.swing.JLabel year2;
    // End of variables declaration//GEN-END:variables
}
