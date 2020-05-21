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
import javax.swing.table.TableModel;
import java.util.Random;

public class homepage extends javax.swing.JFrame {
    
    int page;
    int ian=8987;
    int mics=13;
    
    int exit;
    
    Date date;
    DateFormat format=new SimpleDateFormat("MM/dd/YYYY");
    DateFormat format1=new SimpleDateFormat("hh:mm");
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;
    
    String status;
    String bookCategories;
    String search;
    String bookIDS;
    int select;
    String state;

    String borrow;
    String avail;

    String book_history;
    String search_history;
    
    String historyId;

    String code;
    
    String userId;
    
    String searchUsers;
    String userType;
    
    int selectReport;
    String bookIdHistory;
    
    String history;
    String action;

    int borrowQuan;

    int quantity;
    int issuedBook;
    int returnedBook;

    String borrowed;
    int lengths;

    String chbxCourse;
    String chbxDate;
    
    String issuesId;
    String issuesTitle;
    String issuesAuthor;
    String issuesCategory;
    int returnBooks;
    int issueBooks;
    
    static String fullName;
    static String typeAcc;
    
    public homepage() {
        initComponents();
        setLocationRelativeTo(null);
        
        fullName=login404.name;
        typeAcc=login404.type;
        
        getUserDate();
        getLogDate();
        
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        transparentPanelGroup();
        setActive(dashboardBtn,homePage);
        setSlideShow();
        setTblDesign(bookTable);
        setTblDesign(reportTable);
        setTblDesign(userTable);
        setTblDesign(bInventory);
        setTblDesign(libUserTable);
        setTblDesign(issueMultipleBooks);
        setTblDesign(workLogTable);
        setColumnBookList(bookTable);
        setColumnReport(reportTable);
        setColumnUser(userTable);
        setColumnInventory(bInventory);
        setColumnUsers(libUserTable);
        setColumnIssue(issueMultipleBooks);
        setColumnWork(workLogTable);
        setBookId();
        
    }

    
    //set table design
    void setTblDesign(JTable tblLook){
        tblLook.getTableHeader().setFont(new Font("Kartika", Font.BOLD,12));
        tblLook.getTableHeader().setOpaque(false);
        tblLook.getTableHeader().setBackground(new Color(146,148,148));
        tblLook.getTableHeader().setForeground(new Color(255,255,255));
        tblLook.setRowHeight(20);
        ((DefaultTableCellRenderer)tblLook.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
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
    
    void setColumnReport(JTable table){
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
        col.setPreferredWidth(100);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(4);
        col.setPreferredWidth(50);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(5);
        col.setPreferredWidth(40);
        col.setCellRenderer(center);
        
    }
    
    void setColumnUser(JTable table){
        TableColumn col;
        DefaultTableCellRenderer center= new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        
        col=table.getColumnModel().getColumn(0);
        col.setPreferredWidth(85);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(1);
        col.setPreferredWidth(125);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(3);
        col.setPreferredWidth(85);
        col.setCellRenderer(center);
    }
    
    void setColumnUsers(JTable table){
        TableColumn col;
        DefaultTableCellRenderer center= new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        
        col=table.getColumnModel().getColumn(0);
        col.setPreferredWidth(85);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(1);
        col.setPreferredWidth(125);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(3);
        col.setPreferredWidth(85);
        col.setCellRenderer(center);
    }
    
    void setColumnInventory(JTable table){
        TableColumn col;
        DefaultTableCellRenderer center= new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        
        col=table.getColumnModel().getColumn(0);
        col.setPreferredWidth(125);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(1);
        col.setPreferredWidth(125);
        col.setCellRenderer(center);
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
    
    void setColumnWork(JTable table){ 
        TableColumn col;
        DefaultTableCellRenderer center= new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        
        col=table.getColumnModel().getColumn(0);
        col.setPreferredWidth(35);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(1);
        col.setPreferredWidth(35);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);
        col.setCellRenderer(center);
        col=table.getColumnModel().getColumn(3);
        col.setPreferredWidth(60);
        col.setCellRenderer(center);
    }
    
    void setColumnCategory(JTable table){ 
        TableColumn col;
        DefaultTableCellRenderer center= new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        
        col=table.getColumnModel().getColumn(0);
        col.setPreferredWidth(100);
        col.setCellRenderer(center);
    }
    
    //set Jpanel to tranparent
    void setPanelTranparent(JPanel transparent){
        transparent.setBackground(new Color(0,0,0,0));        
    }
    
    //sets of Jpanel that will be transparent
    void transparentPanelGroup(){
        setPanelTranparent(sideNav);
        setPanelTranparent(body);
        setPanelTranparent(homePage);
        setPanelTranparent(aboutPage);
        setPanelTranparent(userAccountPage);
        setPanelTranparent(bookListPage);
        setPanelTranparent(issueBookPage);
        setPanelTranparent(returnBookPage);
        setPanelTranparent(issueBox);
        setPanelTranparent(returnBox);
        setPanelTranparent(accountSettingPage);
        setPanelTranparent(workLogPage);
        setPanelTranparent(userAccount);
        setPanelTranparent(auditTrail);
        setPanelTranparent(deleteLibrarianPage);
        setPanelTranparent(reportHistoryPage);
        setPanelTranparent(addUser1);
        setPanelTranparent(addAdmin);
        setPanelTranparent(userList);
        setPanelTranparent(transHistory);
        setPanelTranparent(bookInventory);
        setPanelTranparent(libUsers);
        setPanelTranparent(reports);
        setPanelTranparent(user);
        setPanelTranparent(inventory);
        setPanelTranparent(detailsPage);
        setPanelTranparent(issueBooksPage);
        
        
        
    } 
    
    //set active page
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
    
    void setBookListPanel(){
        hidePanelGroup(homePage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(bookListButton,bookListPage);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        
    }

    void setTransactionPanel(){
        hidePanelGroup(bookListPage,homePage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(transactionButton,transactionPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
    }
    
    void setSettingPanel(){
        hidePanelGroup(bookListPage,homePage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,userAccountPage,false);
        hidePanelGroup(transactionPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(settingBtn,accountSettingPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
    }
    
    void setUserAccountPanel(){
        hidePanelGroup(bookListPage,homePage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,accountSettingPage,false);
        hidePanelGroup(transactionPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(settingBtn,userAccountPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
    }
    
    void setReportTable(){
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,homePage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(reportButton,reportHistoryPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        setReportList();
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
                bookCategory.setSelectedIndex(0);
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
                bookCategory.setSelectedIndex(0);
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
            case 5:{
                setSettingPanel();
                break;
            }
            case 6:{
                setUserAccountPanel();
                exit=5;
                break;
            }
            case 7:{
                setUserAccountPanel();
                exit=5;
                break;
            }
            case 8:{
                setSettingPanel();
                break;
            }
            case 9:{
                setReportTable();
                bookHistory.setSelectedIndex(0);
                break;
            }
            case 10:{
                setReportChoices();
                break;
            }
            case 11:{
                setReportChoices();
                break;
            }
            case 12:{
                libUserCourse.setSelectedIndex(0);
                libUserDate.setSelectedIndex(0);
                setReportChoices();
                break;
            }
        }
    }
    
    void setIssuesPanel(JPanel btn,JPanel btn1,JPanel btn2){
        hidePanelGroup(bookListPage,transactionPage,accountSettingPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,homePage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
//        hidePanelGroup(inventory,inventory,user,false);
        setActive(btn,btn2);
        setBtnHover(btn1, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
    }
    
    void setIssuePanel(JPanel btn,JPanel btn1,JPanel btn2){
        hidePanelGroup(bookListPage,transactionPage,accountSettingPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,homePage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(btn,btn2);
        setBtnHover(btn1, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
    }
    
    void setReturnPanel(JPanel btn, JPanel btn1){
        hidePanelGroup(bookListPage,transactionPage,accountSettingPage,false);
        hidePanelGroup(issueBookPage,reportHistoryPage,homePage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(btn,returnBookPage);
        setBtnHover(btn1, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
    }
    
    void setReportDetails(){
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,homePage,false);
        hidePanelGroup(accountSettingPage,userAccountPage,deleteLibrarianPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(workLogPage,inventory,reports,false); 
        hidePanelGroup(user,inventory,reports,false); //naulit
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(reportButton,detailsPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
    }
    
    void setReportChoices(){
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,homePage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reportHistoryPage,aboutPage,user,false); //changable
        hidePanelGroup(inventory,aboutPage,user,false); //changable
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(reportButton,reports);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        setReportList();
        selectReport=-1;
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
    
    void setBookId(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            s=conn.createStatement();
            rs=s.executeQuery("select Max(bookId) from db_booklist");
            rs.next();
            
            rs.getString("Max(bookId)");
            
            if(rs.getString("Max(bookId)")==null){
                bookId.setText("AA001");
                quanty.setText("1");
            }
            else{
                Long id=Long.parseLong(rs.getString("Max(bookId)").substring(2,rs.getString("Max(bookId)").length()));
                id++;
                bookId.setText("AA"+String.format("%03d",id));
                quanty.setText("1");
            }
            
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int issueBook;
    void setAddBook(){
        String book_id=bookId.getText();
        String book_title=title.getText();
        String book_author=author.getText();
        String book_category=(String)bookCategory.getSelectedItem();
        int book_quanty=Integer.parseInt(quanty.getText());
        issueBook=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("insert into db_booklist(bookId,title,author,category,returnBook,issueBook) values(?,?,?,?,?,?)");
            ps.setString(1, book_id);
            ps.setString(2, book_title);
            ps.setString(3, book_author);
            ps.setString(4, book_category);
            ps.setInt(5, book_quanty);
            ps.setInt(6, issueBook);
            ps.executeUpdate();
            
            setBookId();
            JOptionPane.showMessageDialog(null,"The book is successfully saved!","Successful",1);
            title.setText("");
            author.setText("");
            bookCategory.setSelectedIndex(0);
            quanty.setText("1");
            title.requestFocus();
            setBookList();
            
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
    
    void setSearchBook(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_booklist where title like '%"+search+"%' ");
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
    
    void setSearchBookCat(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_booklist where title like '%"+search+"%'and category=? ");
            ps.setString(1, bookCategories);
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
    
    void setReportList(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_history");
            rs=ps.executeQuery();
            
            DefaultTableModel model=(DefaultTableModel)reportTable.getModel();
            model.setRowCount(0);
            reportTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("bookId"),rs.getString("title"),rs.getString("author")
                ,rs.getString("name"),rs.getString("yearSection"),rs.getString("action")};
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
    
    void showBookHistory(String bookHis){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("select * from db_history where action=?" );
            ps.setString(1,bookHis);
            rs=ps.executeQuery();

            DefaultTableModel model=(DefaultTableModel)reportTable.getModel();
            model.setRowCount(0);
            reportTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("bookId"),rs.getString("title"),rs.getString("author")
                ,rs.getString("name"),rs.getString("yearSection"),rs.getString("action")};
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
    
    void searchReport(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_history where title like '%"+search_history+"%'");
            rs=ps.executeQuery();

            DefaultTableModel model=(DefaultTableModel)reportTable.getModel();
            model.setRowCount(0);
            reportTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("bookId"),rs.getString("title"),rs.getString("author")
                ,rs.getString("name"),rs.getString("yearSection"),rs.getString("action")};
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
    
    void searchReportCat(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_history where title like '%"+search_history+"%'and action=? ");
            ps.setString(1, book_history);
            rs=ps.executeQuery();

            DefaultTableModel model=(DefaultTableModel)reportTable.getModel();
            model.setRowCount(0);
            reportTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("bookId"),rs.getString("title"),rs.getString("author")
                ,rs.getString("name"),rs.getString("yearSection"),rs.getString("action")};
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
    
    void setDetails(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_history where historyId=?");
            ps.setString(1,historyReport);
            rs=ps.executeQuery();
            
            if(rs.next()){
                String detailAction=rs.getString("action");
                
                details_name.setText(rs.getString("name"));
                details_studentId.setText(rs.getString("studentId"));
                details_SY.setText(rs.getString("yearSection"));
                details_bookId.setText(rs.getString("bookId"));
                details_action.setText(rs.getString("action"));
                details_title.setText(rs.getString("title"));
                details_author.setText(rs.getString("author"));
                details_category.setText(rs.getString("category"));
                
                if(detailAction.equals("Issue Book")){
                    details_dueDate.setText("Due Date");
                    details_date.setText(rs.getString("date"));
                    details_due.setText(rs.getString("duedate"));
                }
                else if(detailAction.equals("Return Book")){
                    details_dueDate.setText("Return Date");
                    details_date.setText(rs.getString("date"));
                    details_due.setText(rs.getString("duedate"));
                    details_date.setText(rs.getString("date"));
                    details_due.setText(rs.getString("duedate"));
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
    
    void setRandom(){
        String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String randomString="";

        Random random=new Random();
        char[] text=new char[5];
        
        for(int i=0;i<5;i++){
            text[i]=characters.charAt(random.nextInt(characters.length()));
        }
        for(int j=0;j<text.length;j++){
            randomString+=text[j];
        }
        code=randomString;
        
    }
    
    
    void insertRandomCode(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("insert into db_code(code) values(?)");
            ps.setString(1,code);
            ps.executeUpdate();
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void getTblName(){
        String userReg=admin_user.getText();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
    
            ps=conn.prepareStatement("select * from db_signup where username=?");
            ps.setString(1, userReg);
            rs=ps.executeQuery();
                
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Name is already existed!","Error",0);
                admin_user.setText("");
            }
            
            else{
                setUserId();
                setSignUpInfo();
                workStatus="Create Admin Account";
                setStatus(workStatus);
            }
         }
        
        catch (ClassNotFoundException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setSignUpInfo(){
        String lname=admin_lname.getText();
        String fname=admin_fname.getText();
        String mname=admin_mname.getText();
        String age=admin_age.getText();
        String gender=admin_gender.getText();
        String address=admin_address.getText();
        String number=admin_number.getText();
        String email=admin_email.getText();
        String position=admin_position.getText();
        String user=admin_user.getText();
        String pass=admin_pass.getText();
        String type="Admin";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
                        
            ps=conn.prepareStatement("insert into db_signup(id,last,first,middle,age,gender,address,contact,email,position,username,password,type)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, userId);
            ps.setString(2, lname);
            ps.setString(3, fname);
            ps.setString(4, mname);
            ps.setString(5, age);
            ps.setString(6, gender);
            ps.setString(7, address);
            ps.setString(8, number);
            ps.setString(9, email);
            ps.setString(10, position);
            ps.setString(11, user);
            ps.setString(12, pass);
            ps.setString(13, type);
            ps.executeUpdate();
                       
            JOptionPane.showMessageDialog(null, "You are successfully register!", "Sucess", 1);
            
            admin_lname.setText("");
            admin_fname.setText("");
            admin_mname.setText("");
            admin_age.setText("");
            admin_gender.setText("");
            admin_address.setText("");
            admin_number.setText("");
            admin_email.setText("");
            admin_position.setText("");
            admin_user.setText("");
            admin_pass.setText("");
            admin_conpass.setText("");
            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    void setUserList(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_signup");
            rs=ps.executeQuery();
            
            DefaultTableModel model=(DefaultTableModel)userTable.getModel();
            model.setRowCount(0);
            userTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("id"),rs.getString("first")+" "+rs.getString("middle")+" "+rs.getString("last"),rs.getString("type"),rs.getString("position")};
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
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setSearchUsers(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_signup where first like '%"+searchUsers+"%' or last like '%"+searchUsers+"%' or middle like '%"+searchUsers+"%'");
            rs=ps.executeQuery();

            DefaultTableModel model=(DefaultTableModel)userTable.getModel();
            model.setRowCount(0);
            userTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("id"),rs.getString("first")+" "+rs.getString("middle")+" "+rs.getString("last"),rs.getString("type"),rs.getString("position")};
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
    
    void showUserList(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_signup");
            rs=ps.executeQuery();
            
            DefaultTableModel model=(DefaultTableModel)userTable.getModel();
            model.setRowCount(0);
            userTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("id"),rs.getString("first")+" "+rs.getString("middle")+" "+rs.getString("last"),rs.getString("type"),rs.getString("position")};
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
    
    void showUserListType(String type){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("select * from db_signup where type=?" );
            ps.setString(1,type);
            rs=ps.executeQuery();

            DefaultTableModel model=(DefaultTableModel)userTable.getModel();
            model.setRowCount(0);
            userTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("id"),rs.getString("first")+" "+rs.getString("middle")+" "+rs.getString("last"),rs.getString("type"),rs.getString("position")};
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
    
    
    void searchUserType(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_signup where first like '%"+searchUsers+"%' or last like '%"+searchUsers+"%' or middle like '%"+searchUsers+"%' and type=?");
            ps.setString(1, userType);
            rs=ps.executeQuery();

            DefaultTableModel model=(DefaultTableModel)userTable.getModel();
            model.setRowCount(0);
            userTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("id"),rs.getString("first")+" "+rs.getString("middle")+" "+rs.getString("last"),rs.getString("type"),rs.getString("position")};
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
    
    void setDates(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_signup where first like '%"+searchUsers+"%' or last like '%"+searchUsers+"%' or middle like '%"+searchUsers+"%' and type=?");
            ps.setString(1, userType);
            rs=ps.executeQuery();

            DefaultTableModel model=(DefaultTableModel)userTable.getModel();
            model.setRowCount(0);
            userTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("id"),rs.getString("first")+" "+rs.getString("middle")+" "+rs.getString("last"),rs.getString("type"),rs.getString("position")};
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
    
    void getSum(){
        DefaultTableModel model=(DefaultTableModel)bInventory.getModel();
        int rowCount=bInventory.getRowCount();
        int sum=0;
        for(int i=0;i<rowCount;i++){
            sum=sum+Integer.parseInt(bInventory.getValueAt(i,1).toString());
        }
        totalCount.setText(Integer.toString(sum));

    }
    
    void setInventoryBook(String dates){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select category, count(category), action, count(action) from db_history where action=? and "+dates+"=? group by category");
            ps.setString(1, action);
            ps.setString(2, history);
            rs=ps.executeQuery();
            
            DefaultTableModel model=(DefaultTableModel)bInventory.getModel();
            model.setRowCount(0);
            bInventory.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("category"),rs.getInt("count(category)")};
                model.addRow(me);
            }
            getSum();
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setTotalBooks(){
       try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("select sum(returnBook),sum(issueBook) from db_booklist");
            rs=ps.executeQuery();
            
            if(rs.next()){
                totalBooks.setText(Integer.toString(rs.getInt("sum(returnBook)")+rs.getInt("sum(issueBook)")));                
            }
       }
       
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    void setLibraryUser(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_libraryusers order by date desc,time desc");
            rs=ps.executeQuery();
            
            DefaultTableModel model=(DefaultTableModel)libUserTable.getModel();
            model.setRowCount(0);
            libUserTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("date"),rs.getString("name"),rs.getString("course"),rs.getString("section")};
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
    
    void getTotalLibUser(){
        
        DefaultTableModel model=(DefaultTableModel)libUserTable.getModel();
        int rowCount=libUserTable.getRowCount();
        usersTotal.setText(Integer.toString(rowCount));

    }
    
    void getUserDate(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_libraryusers group by date order by date desc");
            rs=ps.executeQuery();
            
            libUserDate.addItem("Select All Dates");
            while(rs.next()){
                libUserDate.addItem(rs.getString("date"));
            }
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void DisplayUserData(){
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select * from db_libraryusers where date=? and course=?");
                ps.setString(1, chbxDate);
                ps.setString(2, chbxCourse);
                rs=ps.executeQuery();

                DefaultTableModel model=(DefaultTableModel)libUserTable.getModel();
                model.setRowCount(0);
                libUserTable.setModel(model);

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
    
    void setLibraryUserData(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_libraryusers where date=?");
            ps.setString(1, chbxDate);
            rs=ps.executeQuery();
            
            DefaultTableModel model=(DefaultTableModel)libUserTable.getModel();
            model.setRowCount(0);
            libUserTable.setModel(model);
            
            while(rs.next()){
                Object me[]={rs.getString("date"),rs.getString("name"),rs.getString("course"),rs.getString("section")};
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
            ps.setString(1, chbxDate);
            rs=ps.executeQuery();
            
            libUserDate.removeAllItems();
            libUserDate.addItem("Select All Dates");
            while(rs.next()){
                libUserDate.addItem(rs.getString("date"));
            }
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    void getSelectIssueBooks(){
        TableModel model=bookTable.getModel();
        int selectBook[]=bookTable.getSelectedRows();
        
        Object[] row=new Object[4];
        
        DefaultTableModel model1=(DefaultTableModel)issueMultipleBooks.getModel();
        model1.setRowCount(0);
        issueMultipleBooks.setModel(model1);
        
        for(int i=0;i<selectBook.length;i++){
            row[0]=model.getValueAt(selectBook[i],0);
            row[1]=model.getValueAt(selectBook[i],1);
            row[2]=model.getValueAt(selectBook[i],2);
            row[3]=model.getValueAt(selectBook[i],3);
        
            model1.addRow(row);
        }
        
    }
    
    void setDeletingBooks(){
        int minus=borrowQuan-1;
        int plus=quantity+1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root",""); // data yung database 

            ps=conn.prepareStatement("update db_booklist set returnBook=?, issueBook=? where bookId=?");
            ps.setInt(1,plus);
            ps.setInt(2,minus);
            ps.setString(3,returnBookID.getText());
            ps.executeUpdate();

            setHistoryId();
            setReturnTransaction();
            setDeleteIssue();

            JOptionPane.showMessageDialog(null,"Return book sucessful");
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
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

            ps=conn.prepareStatement("insert into db_worklog(date,time,type,name,status) values(?,?,?,?,?)");
            ps.setString(1, format.format(date));
            ps.setString(2, format1.format(date));
            ps.setString(3, typeAcc);
            ps.setString(4, fullName);
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
    
    void getLogDate(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select * from db_worklog group by date order by date desc,time desc");
            rs=ps.executeQuery();   
            
            logDate.addItem("Select Date");
            while(rs.next()){
                logDate.addItem(rs.getString("date"));
            }
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setLogDate(String logs){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("select * from db_worklog where date=?" );
            ps.setString(1,logs);
            rs=ps.executeQuery();

            DefaultTableModel model1=(DefaultTableModel)workLogTable.getModel();
            model1.setRowCount(0);
            workLogTable.setModel(model1);
            
            while(rs.next()){
                Object me[]={rs.getString("date"),rs.getString("type"),rs.getString("name"),rs.getString("status")};
                model1.addRow(me);
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void setCategory(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

            ps=conn.prepareStatement("select * from db_category" );
            rs=ps.executeQuery();

            category.addItem("Select Category");
            bookCategory.addItem("Select Category");
            while(rs.next()){
                category.addItem(rs.getString("category"));
                bookCategory.addItem(rs.getString("category"));
            }
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
        reportButton = new javax.swing.JPanel();
        menuIcon2 = new javax.swing.JLabel();
        menu2 = new javax.swing.JLabel();
        aboutBtn = new javax.swing.JPanel();
        aboutIcon = new javax.swing.JLabel();
        about = new javax.swing.JLabel();
        settingBtn = new javax.swing.JPanel();
        settingIcon = new javax.swing.JLabel();
        setting = new javax.swing.JLabel();
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
        searchBar = new javax.swing.JTextField();
        searchLogo = new javax.swing.JLabel();
        issueBookBtn = new javax.swing.JPanel();
        issueWindow = new javax.swing.JLabel();
        returnBookBtn = new javax.swing.JPanel();
        returnWindow = new javax.swing.JLabel();
        labelBookList = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        bookId = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        author = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        bookCategory = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        quanty = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
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
        reports = new javax.swing.JPanel();
        transHistory = new javax.swing.JPanel();
        descrip16 = new javax.swing.JLabel();
        logoBtn16 = new javax.swing.JLabel();
        pink6 = new javax.swing.JLabel();
        bookInventory = new javax.swing.JPanel();
        descrip17 = new javax.swing.JLabel();
        logoBtn17 = new javax.swing.JLabel();
        pink7 = new javax.swing.JLabel();
        libUsers = new javax.swing.JPanel();
        descrip18 = new javax.swing.JLabel();
        logoBtn18 = new javax.swing.JLabel();
        green5 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        bgBlack16 = new javax.swing.JLabel();
        reportHistoryPage = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        bookHistory = new javax.swing.JComboBox<>();
        txtFieldContainer2 = new javax.swing.JPanel();
        searchBookHistory = new javax.swing.JTextField();
        searchLogo2 = new javax.swing.JLabel();
        details = new javax.swing.JPanel();
        detailBtn = new javax.swing.JLabel();
        back9 = new javax.swing.JLabel();
        labelBookList2 = new javax.swing.JLabel();
        bgBlack10 = new javax.swing.JLabel();
        detailsPage = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        details_SY = new javax.swing.JTextField();
        details_studentId = new javax.swing.JTextField();
        details_name = new javax.swing.JTextField();
        details_bookId = new javax.swing.JTextField();
        details_category = new javax.swing.JTextField();
        details_title = new javax.swing.JTextField();
        details_author = new javax.swing.JTextField();
        details_action = new javax.swing.JTextField();
        details_due = new javax.swing.JTextField();
        details_date = new javax.swing.JTextField();
        details_dueDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        back6 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        bgBlack3 = new javax.swing.JLabel();
        inventory = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        bInventory = new javax.swing.JTable();
        selectAction = new javax.swing.JComboBox<>();
        jLabel87 = new javax.swing.JLabel();
        selectHistoryDate = new javax.swing.JComboBox<>();
        back7 = new javax.swing.JLabel();
        totalBooks = new javax.swing.JTextField();
        totalCount = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        bgBlack14 = new javax.swing.JLabel();
        user = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        back8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        libUserTable = new javax.swing.JTable();
        libUserDate = new javax.swing.JComboBox<>();
        libUserCourse = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        usersTotal = new javax.swing.JLabel();
        bgBlack15 = new javax.swing.JLabel();
        accountSettingPage = new javax.swing.JPanel();
        userAccount = new javax.swing.JPanel();
        descrip9 = new javax.swing.JLabel();
        logoBtn9 = new javax.swing.JLabel();
        pink2 = new javax.swing.JLabel();
        auditTrail = new javax.swing.JPanel();
        descrip10 = new javax.swing.JLabel();
        logoBtn10 = new javax.swing.JLabel();
        green2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        bgBlack8 = new javax.swing.JLabel();
        userAccountPage = new javax.swing.JPanel();
        addUser1 = new javax.swing.JPanel();
        descrip13 = new javax.swing.JLabel();
        logoBtn13 = new javax.swing.JLabel();
        pink4 = new javax.swing.JLabel();
        addAdmin = new javax.swing.JPanel();
        descrip15 = new javax.swing.JLabel();
        logoBtn15 = new javax.swing.JLabel();
        pink5 = new javax.swing.JLabel();
        userList = new javax.swing.JPanel();
        descrip14 = new javax.swing.JLabel();
        logoBtn14 = new javax.swing.JLabel();
        green4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        back1 = new javax.swing.JLabel();
        bgBlack11 = new javax.swing.JLabel();
        createAdminPage = new javax.swing.JPanel();
        labelIssueBook2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        issueBookBtn2 = new javax.swing.JPanel();
        adminSignUp = new javax.swing.JLabel();
        personal = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        admin_lname = new javax.swing.JTextField();
        admin_fname = new javax.swing.JTextField();
        admin_mname = new javax.swing.JTextField();
        admin_age = new javax.swing.JTextField();
        admin_gender = new javax.swing.JTextField();
        admin_address = new javax.swing.JTextField();
        admin_number = new javax.swing.JTextField();
        admin_email = new javax.swing.JTextField();
        admin_position = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        account = new javax.swing.JPanel();
        admin_pass = new javax.swing.JPasswordField();
        admin_conpass = new javax.swing.JPasswordField();
        admin_user = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        back3 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        bgBlack7 = new javax.swing.JLabel();
        deleteLibrarianPage = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        txtFieldContainer4 = new javax.swing.JPanel();
        searchUser = new javax.swing.JTextField();
        searchLogo4 = new javax.swing.JLabel();
        categoryType = new javax.swing.JComboBox<>();
        labelBookList4 = new javax.swing.JLabel();
        delete1 = new javax.swing.JLabel();
        back4 = new javax.swing.JLabel();
        bgBlack12 = new javax.swing.JLabel();
        workLogPage = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        workLogTable = new javax.swing.JTable();
        labelBookList1 = new javax.swing.JLabel();
        back5 = new javax.swing.JLabel();
        logDate = new javax.swing.JComboBox<>();
        bgBlack9 = new javax.swing.JLabel();
        aboutPage = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        bgBlack2 = new javax.swing.JLabel();
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

        reportButton.setBackground(new java.awt.Color(134, 191, 230));
        reportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reportButtonMousePressed(evt);
            }
        });
        reportButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/timetable_25px.png"))); // NOI18N
        menuIcon2.setFocusable(false);
        reportButton.add(menuIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        menu2.setFont(new java.awt.Font("Kartika", 1, 14)); // NOI18N
        menu2.setForeground(new java.awt.Color(255, 255, 255));
        menu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu2.setText("     REPORTS");
        menu2.setFocusable(false);
        reportButton.add(menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 198, 35));

        sidenavBtn.add(reportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 107, 198, 35));

        aboutBtn.setBackground(new java.awt.Color(134, 191, 230));
        aboutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutBtnMousePressed(evt);
            }
        });
        aboutBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aboutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/info_30px.png"))); // NOI18N
        aboutIcon.setFocusable(false);
        aboutBtn.add(aboutIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        about.setFont(new java.awt.Font("Kartika", 1, 14)); // NOI18N
        about.setForeground(new java.awt.Color(255, 255, 255));
        about.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        about.setText("ABOUT");
        about.setFocusable(false);
        aboutBtn.add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 198, 35));

        sidenavBtn.add(aboutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 142, 198, 35));

        settingBtn.setBackground(new java.awt.Color(134, 191, 230));
        settingBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingBtnMousePressed(evt);
            }
        });
        settingBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        settingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/settings_30px.png"))); // NOI18N
        settingIcon.setFocusable(false);
        settingBtn.add(settingIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        setting.setBackground(new java.awt.Color(146, 148, 148));
        setting.setFont(new java.awt.Font("Kartika", 1, 14)); // NOI18N
        setting.setForeground(new java.awt.Color(255, 255, 255));
        setting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setting.setText("  SETTING");
        setting.setFocusable(false);
        settingBtn.add(setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 198, 35));

        sidenavBtn.add(settingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 177, 198, 35));

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

        sidenavBtn.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 212, 198, 35));

        sideNav.add(sidenavBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, 250));

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
        if (bookTable.getColumnModel().getColumnCount() > 0) {
            bookTable.getColumnModel().getColumn(0).setResizable(false);
            bookTable.getColumnModel().getColumn(1).setResizable(false);
            bookTable.getColumnModel().getColumn(2).setResizable(false);
            bookTable.getColumnModel().getColumn(3).setResizable(false);
            bookTable.getColumnModel().getColumn(4).setResizable(false);
            bookTable.getColumnModel().getColumn(5).setResizable(false);
        }

        bookListPage.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 160, 550, 280));

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
        bookListPage.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 150, 25));

        txtFieldContainer.setBackground(new java.awt.Color(248, 176, 154));
        txtFieldContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBar.setBackground(new java.awt.Color(248, 176, 154));
        searchBar.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        searchBar.setForeground(new java.awt.Color(255, 255, 255));
        searchBar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        searchBar.setToolTipText("");
        searchBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        searchBar.setCaretColor(new java.awt.Color(255, 255, 255));
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });
        txtFieldContainer.add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 25));

        searchLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/search_20px.png"))); // NOI18N
        txtFieldContainer.add(searchLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 30, 25));

        bookListPage.add(txtFieldContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 180, 25));

        issueBookBtn.setBackground(new java.awt.Color(250, 140, 140));
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

        bookListPage.add(issueBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 80, 28));

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

        bookListPage.add(returnBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 450, 80, 28));

        labelBookList.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        labelBookList.setForeground(new java.awt.Color(255, 255, 255));
        labelBookList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBookList.setText("Book List");
        bookListPage.add(labelBookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 50, 250, -1));

        add.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/add_book_25px.png"))); // NOI18N
        add.setText("Add");
        add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addMousePressed(evt);
            }
        });
        bookListPage.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 435, 65, 30));

        delete.setBackground(new java.awt.Color(140, 255, 140));
        delete.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/minus_20px.png"))); // NOI18N
        delete.setText("Delete");
        delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteMousePressed(evt);
            }
        });
        bookListPage.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 80, 28));

        bookId.setEditable(false);
        bookId.setBackground(new java.awt.Color(248, 176, 154));
        bookId.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        bookId.setForeground(new java.awt.Color(255, 255, 255));
        bookId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bookId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        bookId.setCaretColor(new java.awt.Color(255, 255, 255));
        bookListPage.add(bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 175, 165, 25));

        jLabel31.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Book ID");
        bookListPage.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 155, 165, -1));

        jLabel32.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Title");
        jLabel32.setToolTipText("");
        bookListPage.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 210, 165, -1));

        title.setBackground(new java.awt.Color(248, 176, 154));
        title.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        title.setCaretColor(new java.awt.Color(255, 255, 255));
        bookListPage.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 230, 165, 25));

        jLabel33.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Author");
        jLabel33.setToolTipText("");
        bookListPage.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 265, 165, -1));

        author.setBackground(new java.awt.Color(248, 176, 154));
        author.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        author.setForeground(new java.awt.Color(255, 255, 255));
        author.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        author.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        author.setCaretColor(new java.awt.Color(255, 255, 255));
        bookListPage.add(author, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 285, 165, 25));

        jLabel34.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Category");
        jLabel34.setToolTipText("");
        bookListPage.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 320, 165, -1));

        bookCategory.setBackground(new java.awt.Color(248, 176, 154));
        bookCategory.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        bookCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Mathematics", "English", "Science", "Filipino", "History", "Arts", "Physical Education", "Computer" }));
        bookListPage.add(bookCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 340, 165, 25));

        jLabel57.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Quantity");
        jLabel57.setToolTipText("");
        bookListPage.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 375, 165, -1));

        quanty.setBackground(new java.awt.Color(248, 176, 154));
        quanty.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        quanty.setForeground(new java.awt.Color(255, 255, 255));
        quanty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quanty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        quanty.setCaretColor(new java.awt.Color(255, 255, 255));
        bookListPage.add(quanty, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 395, 165, 25));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bookListPage.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 140, 180, 340));

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
        issueBookPage.add(issueStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 125, 200, 25));

        issueYearSection.setBackground(new java.awt.Color(248, 176, 154));
        issueYearSection.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueYearSection.setForeground(new java.awt.Color(255, 255, 255));
        issueYearSection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueYearSection.setCaretColor(new java.awt.Color(255, 255, 255));
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

        issueTitle.setEditable(false);
        issueTitle.setBackground(new java.awt.Color(248, 176, 154));
        issueTitle.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueTitle.setForeground(new java.awt.Color(255, 255, 255));
        issueTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueTitle.setCaretColor(new java.awt.Color(255, 255, 255));
        issueBookPage.add(issueTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 245, 250, 25));

        issueAuthor.setEditable(false);
        issueAuthor.setBackground(new java.awt.Color(248, 176, 154));
        issueAuthor.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueAuthor.setForeground(new java.awt.Color(255, 255, 255));
        issueAuthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueBookPage.add(issueAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 285, 250, 25));

        issueCategory.setEditable(false);
        issueCategory.setBackground(new java.awt.Color(248, 176, 154));
        issueCategory.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueCategory.setForeground(new java.awt.Color(255, 255, 255));
        issueCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueCategory.setCaretColor(new java.awt.Color(255, 255, 255));
        issueBookPage.add(issueCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 325, 250, 25));

        issueDate.setEditable(false);
        issueDate.setBackground(new java.awt.Color(248, 176, 154));
        issueDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueDate.setForeground(new java.awt.Color(255, 255, 255));
        issueDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueDate.setCaretColor(new java.awt.Color(255, 255, 255));
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

        issueDueDate.setEditable(false);
        issueDueDate.setBackground(new java.awt.Color(248, 176, 154));
        issueDueDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issueDueDate.setForeground(new java.awt.Color(255, 255, 255));
        issueDueDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueDueDate.setCaretColor(new java.awt.Color(255, 255, 255));
        issueBookPage.add(issueDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 405, 100, 25));

        jLabel37.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Category");
        issueBookPage.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        bgBlack5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        issueBookPage.add(bgBlack5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(issueBookPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

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
        if (issueMultipleBooks.getColumnModel().getColumnCount() > 0) {
            issueMultipleBooks.getColumnModel().getColumn(0).setResizable(false);
            issueMultipleBooks.getColumnModel().getColumn(1).setResizable(false);
            issueMultipleBooks.getColumnModel().getColumn(2).setResizable(false);
            issueMultipleBooks.getColumnModel().getColumn(3).setResizable(false);
        }

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
        issueBooksPage.add(issuesStdId, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 155, 180, 25));

        issuesStdName.setBackground(new java.awt.Color(248, 176, 154));
        issuesStdName.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issuesStdName.setForeground(new java.awt.Color(255, 255, 255));
        issuesStdName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        issuesStdName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issuesStdName.setCaretColor(new java.awt.Color(255, 255, 255));
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
        issueBooksPage.add(issuesYS, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 285, 180, 25));

        jLabel93.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Issue Date");
        issueBooksPage.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 325, 180, -1));

        issuesDate.setEditable(false);
        issuesDate.setBackground(new java.awt.Color(248, 176, 154));
        issuesDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issuesDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        issuesDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issueBooksPage.add(issuesDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 350, 180, 25));

        jLabel94.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("Due Date");
        issueBooksPage.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 390, 180, -1));

        issuesDueDate.setEditable(false);
        issuesDueDate.setBackground(new java.awt.Color(248, 176, 154));
        issuesDueDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issuesDueDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        issuesDueDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
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

        returnStudentName.setEditable(false);
        returnStudentName.setBackground(new java.awt.Color(248, 176, 154));
        returnStudentName.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnStudentName.setForeground(new java.awt.Color(255, 255, 255));
        returnStudentName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnStudentName.setCaretColor(new java.awt.Color(255, 255, 255));
        returnStudentName.setEnabled(false);
        returnBookPage.add(returnStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 125, 200, 25));

        returnYearSection.setEditable(false);
        returnYearSection.setBackground(new java.awt.Color(248, 176, 154));
        returnYearSection.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnYearSection.setForeground(new java.awt.Color(255, 255, 255));
        returnYearSection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnYearSection.setCaretColor(new java.awt.Color(255, 255, 255));
        returnYearSection.setEnabled(false);
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

        returnTitle.setEditable(false);
        returnTitle.setBackground(new java.awt.Color(248, 176, 154));
        returnTitle.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnTitle.setForeground(new java.awt.Color(255, 255, 255));
        returnTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnTitle.setCaretColor(new java.awt.Color(255, 255, 255));
        returnBookPage.add(returnTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 245, 250, 25));

        returnAuthor.setEditable(false);
        returnAuthor.setBackground(new java.awt.Color(248, 176, 154));
        returnAuthor.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnAuthor.setForeground(new java.awt.Color(255, 255, 255));
        returnAuthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnBookPage.add(returnAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 285, 250, 25));

        issuedDate.setEditable(false);
        issuedDate.setBackground(new java.awt.Color(248, 176, 154));
        issuedDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        issuedDate.setForeground(new java.awt.Color(255, 255, 255));
        issuedDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        issuedDate.setCaretColor(new java.awt.Color(255, 255, 255));
        returnBookPage.add(issuedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 365, 100, 25));

        returnDate.setEditable(false);
        returnDate.setBackground(new java.awt.Color(248, 176, 154));
        returnDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnDate.setForeground(new java.awt.Color(255, 255, 255));
        returnDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnDate.setCaretColor(new java.awt.Color(255, 255, 255));
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

        returnCategory.setEditable(false);
        returnCategory.setBackground(new java.awt.Color(248, 176, 154));
        returnCategory.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        returnCategory.setForeground(new java.awt.Color(255, 255, 255));
        returnCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        returnBookPage.add(returnCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 325, 250, 25));

        bgBlack6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        returnBookPage.add(bgBlack6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(returnBookPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        reports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transHistoryMousePressed(evt);
            }
        });
        transHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descrip16.setBackground(new java.awt.Color(0, 0, 0));
        descrip16.setFont(new java.awt.Font("Kartika", 1, 18)); // NOI18N
        descrip16.setForeground(new java.awt.Color(255, 255, 255));
        descrip16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descrip16.setText("TRANSACTION");
        descrip16.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        descrip16.setFocusable(false);
        transHistory.add(descrip16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 176, 30));

        logoBtn16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/transaction_approved_100px.png"))); // NOI18N
        transHistory.add(logoBtn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 100, 100));

        pink6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pink6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/orange.png"))); // NOI18N
        pink6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pink6.setFocusable(false);
        pink6.setPreferredSize(new java.awt.Dimension(180, 200));
        transHistory.add(pink6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        reports.add(transHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 160, 180, 200));

        bookInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bookInventoryMousePressed(evt);
            }
        });
        bookInventory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descrip17.setBackground(new java.awt.Color(0, 0, 0));
        descrip17.setFont(new java.awt.Font("Kartika", 1, 18)); // NOI18N
        descrip17.setForeground(new java.awt.Color(255, 255, 255));
        descrip17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descrip17.setText("INVENTORY");
        descrip17.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        descrip17.setFocusable(false);
        bookInventory.add(descrip17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 176, 30));

        logoBtn17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/inventory_flow_100px.png"))); // NOI18N
        bookInventory.add(logoBtn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 100, 100));

        pink7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pink7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/green.png"))); // NOI18N
        pink7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pink7.setFocusable(false);
        pink7.setPreferredSize(new java.awt.Dimension(180, 200));
        bookInventory.add(pink7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        reports.add(bookInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 180, 200));

        libUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        libUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                libUsersMousePressed(evt);
            }
        });
        libUsers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descrip18.setBackground(new java.awt.Color(0, 0, 0));
        descrip18.setFont(new java.awt.Font("Kartika", 1, 18)); // NOI18N
        descrip18.setForeground(new java.awt.Color(255, 255, 255));
        descrip18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descrip18.setText("LIBRARIAN USERS");
        descrip18.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        descrip18.setFocusable(false);
        libUsers.add(descrip18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 176, 30));

        logoBtn18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/user_groups_100px.png"))); // NOI18N
        libUsers.add(logoBtn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 100, 100));

        green5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        green5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/aquamarine.png"))); // NOI18N
        green5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        green5.setFocusable(false);
        green5.setPreferredSize(new java.awt.Dimension(180, 200));
        libUsers.add(green5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        reports.add(libUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 160, 180, 200));

        jLabel86.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Reports");
        reports.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 80, 250, -1));

        bgBlack16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        reports.add(bgBlack16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        reportHistoryPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reportTable.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Kasaysayan", "Ian Destura", "Vice Ganada", null, "Available"},
                {null, "Algebra", "Mica Mediado", "Vicce Ganda", null, "Available"},
                {null, "Biology", "Daina Masicampo", "Vhong Navaro", null, "Available"},
                {null, "Database", "Jonh Smith", "Anne Curtis", null, "Available"},
                {null, "Fitt", "Jason Iris Hilot", "Kuya KIm", null, "Available"}
            },
            new String [] {
                "Book ID", "Title", "Author", "Issue/Return By", "Section&Year", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        reportTable.setRowHeight(18);
        reportTable.setSelectionBackground(new java.awt.Color(249, 142, 138));
        reportTable.setShowVerticalLines(false);
        reportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(reportTable);
        if (reportTable.getColumnModel().getColumnCount() > 0) {
            reportTable.getColumnModel().getColumn(0).setResizable(false);
            reportTable.getColumnModel().getColumn(1).setResizable(false);
            reportTable.getColumnModel().getColumn(2).setResizable(false);
            reportTable.getColumnModel().getColumn(3).setResizable(false);
            reportTable.getColumnModel().getColumn(4).setResizable(false);
            reportTable.getColumnModel().getColumn(5).setResizable(false);
        }

        reportHistoryPage.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 160, 700, 290));

        bookHistory.setBackground(new java.awt.Color(248, 176, 154));
        bookHistory.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        bookHistory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book History", "Issue Book", "Return Book" }));
        bookHistory.setBorder(null);
        bookHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookHistoryActionPerformed(evt);
            }
        });
        reportHistoryPage.add(bookHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 150, 25));

        txtFieldContainer2.setBackground(new java.awt.Color(248, 176, 154));
        txtFieldContainer2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBookHistory.setBackground(new java.awt.Color(248, 176, 154));
        searchBookHistory.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        searchBookHistory.setForeground(new java.awt.Color(255, 255, 255));
        searchBookHistory.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        searchBookHistory.setToolTipText("");
        searchBookHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        searchBookHistory.setCaretColor(new java.awt.Color(255, 255, 255));
        searchBookHistory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBookHistoryKeyReleased(evt);
            }
        });
        txtFieldContainer2.add(searchBookHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 25));

        searchLogo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/search_20px.png"))); // NOI18N
        txtFieldContainer2.add(searchLogo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 30, 25));

        reportHistoryPage.add(txtFieldContainer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 180, 25));

        details.setBackground(new java.awt.Color(0, 212, 0));
        details.setForeground(new java.awt.Color(255, 255, 255));
        details.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        details.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        detailBtn.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        detailBtn.setForeground(new java.awt.Color(255, 255, 255));
        detailBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailBtn.setText("Details");
        detailBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        detailBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                detailBtnMousePressed(evt);
            }
        });
        details.add(detailBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 25));

        reportHistoryPage.add(details, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 468, 80, 25));

        back9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back9MousePressed(evt);
            }
        });
        reportHistoryPage.add(back9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        labelBookList2.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        labelBookList2.setForeground(new java.awt.Color(255, 255, 255));
        labelBookList2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBookList2.setText("History");
        reportHistoryPage.add(labelBookList2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 300, -1));

        bgBlack10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        reportHistoryPage.add(bgBlack10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(reportHistoryPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        detailsPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Book Details");
        detailsPage.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 400, 30));

        jLabel5.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");
        detailsPage.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Student ID");
        detailsPage.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabel39.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Section & Year");
        detailsPage.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        jLabel40.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Book ID");
        detailsPage.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        jLabel41.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Book Title");
        detailsPage.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        jLabel45.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Action");
        detailsPage.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        jLabel42.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Book Author");
        detailsPage.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, -1));

        jLabel43.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Book Category");
        detailsPage.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        jLabel44.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Issued Date");
        detailsPage.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, -1));

        details_SY.setEditable(false);
        details_SY.setBackground(new java.awt.Color(248, 176, 154));
        details_SY.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_SY.setForeground(new java.awt.Color(255, 255, 255));
        details_SY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        details_SY.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsPage.add(details_SY, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 205, 150, 25));

        details_studentId.setEditable(false);
        details_studentId.setBackground(new java.awt.Color(248, 176, 154));
        details_studentId.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_studentId.setForeground(new java.awt.Color(255, 255, 255));
        details_studentId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        details_studentId.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsPage.add(details_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 165, 150, 25));

        details_name.setEditable(false);
        details_name.setBackground(new java.awt.Color(248, 176, 154));
        details_name.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_name.setForeground(new java.awt.Color(255, 255, 255));
        details_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        details_name.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsPage.add(details_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 125, 200, 25));

        details_bookId.setEditable(false);
        details_bookId.setBackground(new java.awt.Color(248, 176, 154));
        details_bookId.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_bookId.setForeground(new java.awt.Color(255, 255, 255));
        details_bookId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        details_bookId.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsPage.add(details_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 295, 110, 25));

        details_category.setEditable(false);
        details_category.setBackground(new java.awt.Color(248, 176, 154));
        details_category.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_category.setForeground(new java.awt.Color(255, 255, 255));
        details_category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        details_category.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsPage.add(details_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 415, 150, 25));

        details_title.setEditable(false);
        details_title.setBackground(new java.awt.Color(248, 176, 154));
        details_title.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_title.setForeground(new java.awt.Color(255, 255, 255));
        details_title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        details_title.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsPage.add(details_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 335, 300, 25));

        details_author.setEditable(false);
        details_author.setBackground(new java.awt.Color(248, 176, 154));
        details_author.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_author.setForeground(new java.awt.Color(255, 255, 255));
        details_author.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        details_author.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsPage.add(details_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 375, 300, 25));

        details_action.setEditable(false);
        details_action.setBackground(new java.awt.Color(248, 176, 154));
        details_action.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_action.setForeground(new java.awt.Color(255, 255, 255));
        details_action.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        details_action.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsPage.add(details_action, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 295, 120, 25));

        details_due.setEditable(false);
        details_due.setBackground(new java.awt.Color(248, 176, 154));
        details_due.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_due.setForeground(new java.awt.Color(255, 255, 255));
        details_due.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        details_due.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsPage.add(details_due, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 455, 80, 25));

        details_date.setEditable(false);
        details_date.setBackground(new java.awt.Color(248, 176, 154));
        details_date.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_date.setForeground(new java.awt.Color(255, 255, 255));
        details_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        details_date.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsPage.add(details_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 455, 80, 25));

        details_dueDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        details_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        details_dueDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        details_dueDate.setText("Returned Date");
        detailsPage.add(details_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 95, -1));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Student Info", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Kartika", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        detailsPage.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 450, 150));

        back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back6MousePressed(evt);
            }
        });
        detailsPage.add(back6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        jLabel46.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Book Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Kartika", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        detailsPage.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 450, 240));

        bgBlack3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        detailsPage.add(bgBlack3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(detailsPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        inventory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("Inventory Book");
        inventory.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 400, 30));

        bInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bInventory.setSelectionBackground(new java.awt.Color(249, 142, 138));
        jScrollPane6.setViewportView(bInventory);
        if (bInventory.getColumnModel().getColumnCount() > 0) {
            bInventory.getColumnModel().getColumn(0).setResizable(false);
            bInventory.getColumnModel().getColumn(1).setResizable(false);
        }

        inventory.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 110, -1, 380));

        selectAction.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        selectAction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Action", "Issue Book", "Return Book", "" }));
        selectAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionActionPerformed(evt);
            }
        });
        inventory.add(selectAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 200, 200, 25));

        jLabel87.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Number of Total Books");
        inventory.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 285, 200, -1));

        selectHistoryDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        selectHistoryDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select History Date" }));
        selectHistoryDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectHistoryDateActionPerformed(evt);
            }
        });
        inventory.add(selectHistoryDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 245, 200, 25));

        back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back7MousePressed(evt);
            }
        });
        inventory.add(back7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        totalBooks.setEditable(false);
        totalBooks.setBackground(new java.awt.Color(248, 176, 154));
        totalBooks.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        totalBooks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalBooks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        inventory.add(totalBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 310, 200, 25));

        totalCount.setEditable(false);
        totalCount.setBackground(new java.awt.Color(248, 176, 154));
        totalCount.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        totalCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalCount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        inventory.add(totalCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 370, 200, 25));

        jLabel89.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("Total Count");
        inventory.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 345, 200, -1));

        jLabel77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        inventory.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 150, 245, 300));

        bgBlack14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        inventory.add(bgBlack14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(inventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        user.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel88.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Library User");
        user.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 400, 30));

        back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back8MousePressed(evt);
            }
        });
        user.add(back8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        libUserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Time", "Name", "Course", "Section"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        libUserTable.setSelectionBackground(new java.awt.Color(249, 142, 138));
        jScrollPane4.setViewportView(libUserTable);
        if (libUserTable.getColumnModel().getColumnCount() > 0) {
            libUserTable.getColumnModel().getColumn(0).setResizable(false);
            libUserTable.getColumnModel().getColumn(1).setResizable(false);
            libUserTable.getColumnModel().getColumn(2).setResizable(false);
            libUserTable.getColumnModel().getColumn(3).setResizable(false);
        }

        user.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 140, 720, 360));

        libUserDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        libUserDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                libUserDateFocusGained(evt);
            }
        });
        libUserDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libUserDateActionPerformed(evt);
            }
        });
        user.add(libUserDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 150, 25));

        libUserCourse.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        libUserCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select All Courses", "BSIT", "BSCS", "BSHM", "BSBM", "BSC", "BSP", "BSE" }));
        libUserCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libUserCourseActionPerformed(evt);
            }
        });
        user.add(libUserCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 150, 25));

        jLabel1.setFont(new java.awt.Font("KaiTi", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Number:");
        user.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 108, -1, -1));

        usersTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        usersTotal.setForeground(new java.awt.Color(255, 255, 255));
        usersTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usersTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        user.add(usersTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 95, 60, 40));

        bgBlack15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        user.add(bgBlack15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        accountSettingPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userAccountMousePressed(evt);
            }
        });
        userAccount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descrip9.setBackground(new java.awt.Color(0, 0, 0));
        descrip9.setFont(new java.awt.Font("Kartika", 1, 18)); // NOI18N
        descrip9.setForeground(new java.awt.Color(255, 255, 255));
        descrip9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descrip9.setText("USER ACCOUNT");
        descrip9.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        descrip9.setFocusable(false);
        userAccount.add(descrip9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 176, 30));

        logoBtn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/user_male_circle_100px.png"))); // NOI18N
        userAccount.add(logoBtn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 100, 100));

        pink2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pink2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/red.png"))); // NOI18N
        pink2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pink2.setFocusable(false);
        pink2.setPreferredSize(new java.awt.Dimension(180, 200));
        userAccount.add(pink2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        accountSettingPage.add(userAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 180, 200));

        auditTrail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        auditTrail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                auditTrailMousePressed(evt);
            }
        });
        auditTrail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descrip10.setBackground(new java.awt.Color(0, 0, 0));
        descrip10.setFont(new java.awt.Font("Kartika", 1, 18)); // NOI18N
        descrip10.setForeground(new java.awt.Color(255, 255, 255));
        descrip10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descrip10.setText("AUDIT TRAIL");
        descrip10.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        descrip10.setFocusable(false);
        auditTrail.add(descrip10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 176, 30));

        logoBtn10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/meeting_time_100px.png"))); // NOI18N
        auditTrail.add(logoBtn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 100, 100));

        green2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        green2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/aquamarine.png"))); // NOI18N
        green2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        green2.setFocusable(false);
        green2.setPreferredSize(new java.awt.Dimension(180, 200));
        auditTrail.add(green2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        accountSettingPage.add(auditTrail, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 180, 200));

        jLabel22.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Librarian");
        accountSettingPage.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 80, 250, -1));

        bgBlack8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        accountSettingPage.add(bgBlack8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(accountSettingPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        userAccountPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addUser1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addUser1MousePressed(evt);
            }
        });
        addUser1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descrip13.setBackground(new java.awt.Color(0, 0, 0));
        descrip13.setFont(new java.awt.Font("Kartika", 1, 18)); // NOI18N
        descrip13.setForeground(new java.awt.Color(255, 255, 255));
        descrip13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descrip13.setText("ADD USER");
        descrip13.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        descrip13.setFocusable(false);
        addUser1.add(descrip13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 176, 30));

        logoBtn13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/add_user_male_100px.png"))); // NOI18N
        addUser1.add(logoBtn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 100, 100));

        pink4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pink4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/aquamarine.png"))); // NOI18N
        pink4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pink4.setFocusable(false);
        pink4.setPreferredSize(new java.awt.Dimension(180, 200));
        addUser1.add(pink4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        userAccountPage.add(addUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 160, 180, 200));

        addAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addAdminMousePressed(evt);
            }
        });
        addAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descrip15.setBackground(new java.awt.Color(0, 0, 0));
        descrip15.setFont(new java.awt.Font("Kartika", 1, 18)); // NOI18N
        descrip15.setForeground(new java.awt.Color(255, 255, 255));
        descrip15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descrip15.setText("ADD ADMIN");
        descrip15.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        descrip15.setFocusable(false);
        addAdmin.add(descrip15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 176, 30));

        logoBtn15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/add_user_male_100px.png"))); // NOI18N
        addAdmin.add(logoBtn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 100, 100));

        pink5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pink5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/blue.png"))); // NOI18N
        pink5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pink5.setFocusable(false);
        pink5.setPreferredSize(new java.awt.Dimension(180, 200));
        addAdmin.add(pink5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        userAccountPage.add(addAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 180, 200));

        userList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userListMousePressed(evt);
            }
        });
        userList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descrip14.setBackground(new java.awt.Color(0, 0, 0));
        descrip14.setFont(new java.awt.Font("Kartika", 1, 18)); // NOI18N
        descrip14.setForeground(new java.awt.Color(255, 255, 255));
        descrip14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descrip14.setText("USER LIST");
        descrip14.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        descrip14.setFocusable(false);
        userList.add(descrip14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, 176, 30));

        logoBtn14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/checklist_100px.png"))); // NOI18N
        userList.add(logoBtn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 100, 100));

        green4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        green4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/red.png"))); // NOI18N
        green4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        green4.setFocusable(false);
        green4.setPreferredSize(new java.awt.Dimension(180, 200));
        userList.add(green4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        userAccountPage.add(userList, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 160, 180, 200));

        jLabel24.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Librarian");
        userAccountPage.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 80, 250, -1));

        back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back1MousePressed(evt);
            }
        });
        userAccountPage.add(back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        bgBlack11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        userAccountPage.add(bgBlack11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(userAccountPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        createAdminPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIssueBook2.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        labelIssueBook2.setForeground(new java.awt.Color(255, 255, 255));
        labelIssueBook2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIssueBook2.setText("Create Account");
        createAdminPage.add(labelIssueBook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 250, -1));

        jLabel21.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Full Name");
        createAdminPage.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 160, -1, -1));

        jLabel25.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Age");
        createAdminPage.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 195, -1, -1));

        jLabel26.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Gender");
        createAdminPage.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 230, -1, -1));

        jLabel27.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Address");
        createAdminPage.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 265, -1, -1));

        jLabel28.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Contact No.:");
        createAdminPage.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 300, -1, -1));

        jLabel29.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Email");
        createAdminPage.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 335, -1, -1));

        jLabel30.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Position");
        createAdminPage.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 370, -1, -1));

        issueBookBtn2.setBackground(new java.awt.Color(250, 140, 140));
        issueBookBtn2.setForeground(new java.awt.Color(255, 255, 255));
        issueBookBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueBookBtn2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminSignUp.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        adminSignUp.setForeground(new java.awt.Color(255, 255, 255));
        adminSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminSignUp.setText("Sign Up");
        adminSignUp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        adminSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adminSignUpMousePressed(evt);
            }
        });
        issueBookBtn2.add(adminSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 25));

        createAdminPage.add(issueBookBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 80, 25));

        personal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setForeground(new java.awt.Color(204, 255, 255));
        jLabel52.setText("Last Name");
        personal.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel54.setForeground(new java.awt.Color(204, 255, 255));
        jLabel54.setText("Middle Name");
        personal.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        jLabel53.setForeground(new java.awt.Color(204, 255, 255));
        jLabel53.setText("First Name");
        personal.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        admin_lname.setBackground(new java.awt.Color(248, 176, 154));
        admin_lname.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        admin_lname.setForeground(new java.awt.Color(255, 255, 255));
        admin_lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_lname.setCaretColor(new java.awt.Color(255, 255, 255));
        personal.add(admin_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 90, 25));

        admin_fname.setBackground(new java.awt.Color(248, 176, 154));
        admin_fname.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        admin_fname.setForeground(new java.awt.Color(255, 255, 255));
        admin_fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_fname.setCaretColor(new java.awt.Color(255, 255, 255));
        personal.add(admin_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 5, 90, 25));

        admin_mname.setBackground(new java.awt.Color(248, 176, 154));
        admin_mname.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        admin_mname.setForeground(new java.awt.Color(255, 255, 255));
        admin_mname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_mname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_mname.setCaretColor(new java.awt.Color(255, 255, 255));
        personal.add(admin_mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, 80, 25));

        admin_age.setBackground(new java.awt.Color(248, 176, 154));
        admin_age.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        admin_age.setForeground(new java.awt.Color(255, 255, 255));
        admin_age.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_age.setCaretColor(new java.awt.Color(255, 255, 255));
        admin_age.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                admin_ageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                admin_ageFocusLost(evt);
            }
        });
        admin_age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                admin_ageKeyTyped(evt);
            }
        });
        personal.add(admin_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 45, 100, 25));

        admin_gender.setBackground(new java.awt.Color(248, 176, 154));
        admin_gender.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        admin_gender.setForeground(new java.awt.Color(255, 255, 255));
        admin_gender.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_gender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_gender.setCaretColor(new java.awt.Color(255, 255, 255));
        personal.add(admin_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 100, 25));

        admin_address.setBackground(new java.awt.Color(248, 176, 154));
        admin_address.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        admin_address.setForeground(new java.awt.Color(255, 255, 255));
        admin_address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_address.setCaretColor(new java.awt.Color(255, 255, 255));
        personal.add(admin_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 115, 250, 25));

        admin_number.setBackground(new java.awt.Color(248, 176, 154));
        admin_number.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        admin_number.setForeground(new java.awt.Color(255, 255, 255));
        admin_number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_number.setCaretColor(new java.awt.Color(255, 255, 255));
        admin_number.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                admin_numberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                admin_numberFocusLost(evt);
            }
        });
        admin_number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                admin_numberKeyTyped(evt);
            }
        });
        personal.add(admin_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 150, 25));

        admin_email.setBackground(new java.awt.Color(248, 176, 154));
        admin_email.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        admin_email.setForeground(new java.awt.Color(255, 255, 255));
        admin_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_email.setCaretColor(new java.awt.Color(255, 255, 255));
        personal.add(admin_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 185, 200, 25));

        admin_position.setBackground(new java.awt.Color(248, 176, 154));
        admin_position.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        admin_position.setForeground(new java.awt.Color(255, 255, 255));
        admin_position.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_position.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_position.setCaretColor(new java.awt.Color(255, 255, 255));
        personal.add(admin_position, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 150, 25));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black2.png"))); // NOI18N
        jLabel56.setText("jLabel47");
        personal.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 260));

        createAdminPage.add(personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 145, 380, 260));

        account.setBackground(new java.awt.Color(51, 51, 51));
        account.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_pass.setBackground(new java.awt.Color(248, 176, 154));
        admin_pass.setForeground(new java.awt.Color(255, 255, 255));
        admin_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_pass.setCaretColor(new java.awt.Color(255, 255, 255));
        account.add(admin_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 120, 200, 25));

        admin_conpass.setBackground(new java.awt.Color(248, 176, 154));
        admin_conpass.setForeground(new java.awt.Color(255, 255, 255));
        admin_conpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_conpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_conpass.setCaretColor(new java.awt.Color(255, 255, 255));
        account.add(admin_conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, 200, 25));

        admin_user.setBackground(new java.awt.Color(248, 176, 154));
        admin_user.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        admin_user.setForeground(new java.awt.Color(255, 255, 255));
        admin_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        admin_user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        admin_user.setCaretColor(new java.awt.Color(255, 255, 255));
        account.add(admin_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 200, 25));

        jLabel51.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Confirm Password");
        account.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 160, 200, -1));

        jLabel49.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Username");
        account.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 200, -1));

        jLabel50.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Password");
        account.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, 200, -1));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black2.png"))); // NOI18N
        jLabel47.setText("jLabel47");
        account.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 240));

        createAdminPage.add(account, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 230, 240));

        back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back3MousePressed(evt);
            }
        });
        createAdminPage.add(back3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        jLabel55.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Personal Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Kartika", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        createAdminPage.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 120, 400, 300));

        jLabel48.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Account Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Kartika", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        createAdminPage.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 120, 280, 300));

        bgBlack7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        createAdminPage.add(bgBlack7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(createAdminPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        deleteLibrarianPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userTable.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Ian C. Destura", null, "Active"},
                {null, "Mica Mediado", null, "Active"},
                {null, "Daina Masicampo", null, "Active"},
                {null, "Jason Iris Hilot", null, "Active"},
                {null, "Jonh Smith", null, "Active"}
            },
            new String [] {
                "User ID", "Librarian Name", "Type", "Position"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTable.setRowHeight(18);
        userTable.setSelectionBackground(new java.awt.Color(249, 142, 138));
        userTable.setShowVerticalLines(false);
        jScrollPane5.setViewportView(userTable);
        if (userTable.getColumnModel().getColumnCount() > 0) {
            userTable.getColumnModel().getColumn(0).setResizable(false);
            userTable.getColumnModel().getColumn(1).setResizable(false);
            userTable.getColumnModel().getColumn(2).setResizable(false);
            userTable.getColumnModel().getColumn(3).setResizable(false);
        }

        deleteLibrarianPage.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 170, 700, 280));

        txtFieldContainer4.setBackground(new java.awt.Color(248, 176, 154));
        txtFieldContainer4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchUser.setBackground(new java.awt.Color(248, 176, 154));
        searchUser.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        searchUser.setForeground(new java.awt.Color(255, 255, 255));
        searchUser.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        searchUser.setToolTipText("");
        searchUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 176, 154)));
        searchUser.setCaretColor(new java.awt.Color(255, 255, 255));
        searchUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchUserKeyReleased(evt);
            }
        });
        txtFieldContainer4.add(searchUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 25));

        searchLogo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchLogo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/search_20px.png"))); // NOI18N
        txtFieldContainer4.add(searchLogo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 30, 25));

        deleteLibrarianPage.add(txtFieldContainer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 180, 25));

        categoryType.setBackground(new java.awt.Color(248, 176, 154));
        categoryType.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        categoryType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Admin", "Librarian" }));
        categoryType.setBorder(null);
        categoryType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoryType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryTypeActionPerformed(evt);
            }
        });
        deleteLibrarianPage.add(categoryType, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 150, 25));

        labelBookList4.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        labelBookList4.setForeground(new java.awt.Color(255, 255, 255));
        labelBookList4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBookList4.setText("Users");
        deleteLibrarianPage.add(labelBookList4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 325, -1));

        delete1.setBackground(new java.awt.Color(140, 255, 140));
        delete1.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        delete1.setForeground(new java.awt.Color(255, 255, 255));
        delete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/minus_20px.png"))); // NOI18N
        delete1.setText("Delete");
        delete1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        delete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delete1MousePressed(evt);
            }
        });
        deleteLibrarianPage.add(delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 80, 28));

        back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back4MousePressed(evt);
            }
        });
        deleteLibrarianPage.add(back4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        bgBlack12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        deleteLibrarianPage.add(bgBlack12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(deleteLibrarianPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        workLogPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workLogTable.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        workLogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Type", "User", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workLogTable.setRowHeight(18);
        workLogTable.setSelectionBackground(new java.awt.Color(249, 142, 138));
        workLogTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(workLogTable);
        if (workLogTable.getColumnModel().getColumnCount() > 0) {
            workLogTable.getColumnModel().getColumn(0).setResizable(false);
            workLogTable.getColumnModel().getColumn(1).setResizable(false);
            workLogTable.getColumnModel().getColumn(2).setResizable(false);
            workLogTable.getColumnModel().getColumn(3).setResizable(false);
        }

        workLogPage.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 150, 700, 350));

        labelBookList1.setFont(new java.awt.Font("Kartika", 0, 24)); // NOI18N
        labelBookList1.setForeground(new java.awt.Color(255, 255, 255));
        labelBookList1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBookList1.setText("Work Log");
        workLogPage.add(labelBookList1, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 60, 250, -1));

        back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon/arrow_pointing_left_50px.png"))); // NOI18N
        back5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                back5MousePressed(evt);
            }
        });
        workLogPage.add(back5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 45, 40));

        logDate.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        logDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logDateActionPerformed(evt);
            }
        });
        workLogPage.add(logDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 160, 25));

        bgBlack9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        workLogPage.add(bgBlack9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(workLogPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        aboutPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scroll.setBackground(new java.awt.Color(51, 51, 255));
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/scroll.png"))); // NOI18N
        jPanel1.add(jLabel75);

        scroll.setViewportView(jPanel1);

        aboutPage.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        bgBlack2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/black.png"))); // NOI18N
        aboutPage.add(bgBlack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

        body.add(aboutPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 755, 515));

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
        transactionPage.isVisible()==true&&transactionPage.isEnabled()==true||
        accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true||
        reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true||
        aboutPage.isVisible()==true&&aboutPage.isEnabled()==true){
            setBtnHover(dashboardBtn, 249, 142, 138);
        }
    }//GEN-LAST:event_dashboardBtnMouseEntered

    private void dashboardBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnMouseExited
        if(homePage.isVisible()==true&&homePage.isEnabled()==true){
            setBtnHover(dashboardBtn, 249, 142, 138);
        }
        else if(bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
        transactionPage.isVisible()==true&&transactionPage.isEnabled()==true||
        accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true||
        reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true||
        aboutPage.isVisible()==true&&aboutPage.isEnabled()==true){
            setBtnHover(dashboardBtn, 134, 191, 230);
        }
    }//GEN-LAST:event_dashboardBtnMouseExited

    private void bookListButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookListButtonMouseEntered
        if(bookListPage.isVisible()==true&&bookListPage.isEnabled()==true){
            setBtnHover(bookListButton, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
        transactionPage.isVisible()==true&&transactionPage.isEnabled()==true||
        accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true||
        reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true||
        aboutPage.isVisible()==true&&aboutPage.isEnabled()==true){
            setBtnHover(bookListButton, 249, 142, 138);
        }
    }//GEN-LAST:event_bookListButtonMouseEntered

    private void bookListButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookListButtonMouseExited
        if(bookListPage.isVisible()==true&&bookListPage.isEnabled()==true){
            setBtnHover(bookListButton, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
        transactionPage.isVisible()==true&&transactionPage.isEnabled()==true||
        accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true||
        reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true||
        aboutPage.isVisible()==true&&aboutPage.isEnabled()==true){
            setBtnHover(bookListButton, 134, 191, 230);
        }
    }//GEN-LAST:event_bookListButtonMouseExited

    private void transactionButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionButtonMouseEntered
        if(transactionPage.isVisible()==true&&transactionPage.isEnabled()==true){
            setBtnHover(transactionButton, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
        bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
        accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true||
        reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true||
        aboutPage.isVisible()==true&&aboutPage.isEnabled()==true){
            setBtnHover(transactionButton, 249, 142, 138);
        }
    }//GEN-LAST:event_transactionButtonMouseEntered

    private void transactionButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionButtonMouseExited
        if(transactionPage.isVisible()==true&&transactionPage.isEnabled()==true){
            setBtnHover(transactionButton, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
        bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
        accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true||
        reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true||
        aboutPage.isVisible()==true&&aboutPage.isEnabled()==true){
            setBtnHover(transactionButton, 134, 191, 230);
        }
    }//GEN-LAST:event_transactionButtonMouseExited

    private void reportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseEntered
        if(reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true){
            setBtnHover(reportButton, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
        bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
        accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true||
        transactionPage.isVisible()==true&&transactionPage.isEnabled()==true||
        aboutPage.isVisible()==true&&aboutPage.isEnabled()==true){
            setBtnHover(reportButton, 249, 142, 138);
        }
    }//GEN-LAST:event_reportButtonMouseEntered

    private void reportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseExited
        if(reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true){
            setBtnHover(reportButton, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
        bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
        accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true||
        transactionPage.isVisible()==true&&transactionPage.isEnabled()==true||
        aboutPage.isVisible()==true&&aboutPage.isEnabled()==true){
            setBtnHover(reportButton, 134, 191, 230);
        }
    }//GEN-LAST:event_reportButtonMouseExited

    private void aboutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutBtnMouseEntered
        if(aboutPage.isVisible()==true&&aboutPage.isEnabled()==true){
            setBtnHover(aboutBtn, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
        bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
        accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true||
        transactionPage.isVisible()==true&&transactionPage.isEnabled()==true||
        reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true){
            setBtnHover(aboutBtn, 249, 142, 138);
        }
    }//GEN-LAST:event_aboutBtnMouseEntered

    private void aboutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutBtnMouseExited
        if(aboutPage.isVisible()==true&&aboutPage.isEnabled()==true){
            setBtnHover(aboutBtn, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
        bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
        accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true||
        transactionPage.isVisible()==true&&transactionPage.isEnabled()==true||
        reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true){
            setBtnHover(aboutBtn, 134, 191, 230);
        }
    }//GEN-LAST:event_aboutBtnMouseExited

    private void settingBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingBtnMouseEntered
        if(accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true){
            setBtnHover(settingBtn, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
        bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
        aboutPage.isVisible()==true&&aboutPage.isEnabled()==true||
        transactionPage.isVisible()==true&&transactionPage.isEnabled()==true||
        reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true){
            setBtnHover(settingBtn, 249, 142, 138);
        }
    }//GEN-LAST:event_settingBtnMouseEntered

    private void settingBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingBtnMouseExited
        if(accountSettingPage.isVisible()==true&&accountSettingPage.isEnabled()==true){
            setBtnHover(settingBtn, 249, 142, 138);
        }
        else if(homePage.isVisible()==true&&homePage.isEnabled()==true||
        bookListPage.isVisible()==true&&bookListPage.isEnabled()==true||
        aboutPage.isVisible()==true&&aboutPage.isEnabled()==true||
        transactionPage.isVisible()==true&&transactionPage.isEnabled()==true||
        reportHistoryPage.isVisible()==true&&reportHistoryPage.isEnabled()==true){
            setBtnHover(settingBtn, 134, 191,230);
        }
    }//GEN-LAST:event_settingBtnMouseExited

    private void logoutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseEntered
        setBtnHover(logoutBtn, 249, 142, 138);        
    }//GEN-LAST:event_logoutBtnMouseEntered

    private void logoutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseExited
        setBtnHover(logoutBtn, 134, 191, 230);        
    }//GEN-LAST:event_logoutBtnMouseExited

    private void dashboardBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(dashboardBtn,homePage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
    }//GEN-LAST:event_dashboardBtnMousePressed

    private void bookListButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookListButtonMousePressed
        hidePanelGroup(homePage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(bookListButton,bookListPage);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        setBookList();
        category.setSelectedIndex(0);
        bookCategory.setSelectedIndex(0);
        select=-1;
//        quantity=0;
//        borrowQuan=0;
    }//GEN-LAST:event_bookListButtonMousePressed

    private void transactionButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionButtonMousePressed
        hidePanelGroup(bookListPage,homePage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(transactionButton,transactionPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
    }//GEN-LAST:event_transactionButtonMousePressed

    private void reportButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,homePage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reportHistoryPage,aboutPage,user,false); //changable
        hidePanelGroup(inventory,issueBooksPage,inventory,false);
        setActive(reportButton,reports);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        setReportList();
        selectReport=-1;
    }//GEN-LAST:event_reportButtonMousePressed

    private void aboutBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutBtnMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,homePage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(aboutBtn,aboutPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
    }//GEN-LAST:event_aboutBtnMousePressed

    private void settingBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingBtnMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,homePage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(settingBtn,accountSettingPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
    }//GEN-LAST:event_settingBtnMousePressed

    private void logoutBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMousePressed
        workStatus="Log Out";
        setStatus(workStatus);
        new login404().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnMousePressed
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
                setSelectIssue();
            }
            else if(typeUser.equals("2")){
                setIssuePanel(bookListButton,transactionButton,issueBookPage);
                issueBookID.setEnabled(false);
                id.setText("Teacher ID");
                name.setText("Teacher Name");
                year.setText("Department");
                setSelectIssue();
            }
            else if(typeUser.equals("3")){
                setBookList();
                select=-1;
            }
            else if(!typeUser.equals("3")){
                JOptionPane.showMessageDialog(null,"Incorrect choices","Error",0);
                setBookList();
                select=-1;
            }
        }
        
        else if((lengths==2||lengths==3)&&bookAvail!=1){
            String typeUser=JOptionPane.showInputDialog(null,"Please select one: \n 1. Student \n 2. Teacher \n 3. Exit" ,"Message",3); 
            numChoice=typeUser;
            
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
            else if(typeUser.equals("3")){
                setBookList();
                select=-1;
            }
            else if(!typeUser.equals("3")){
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
            bookAvail=0;
        }
        
    }//GEN-LAST:event_issueWindowMousePressed
    
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
                returnDate.setText(format.format(date)); 
            }
            
        }
        

    }//GEN-LAST:event_returnWindowMousePressed

    private void back2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back2MousePressed
        setBackArrow();
    }//GEN-LAST:event_back2MousePressed

    private void issueBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueBoxMousePressed
        String typeUser=JOptionPane.showInputDialog(null,"Please select one: \n 1. Student \n 2. Teacher \n 3. Exit" ,"Message",3); 
        
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

    private void userAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userAccountMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,homePage,false);
        hidePanelGroup(accountSettingPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(settingBtn,userAccountPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        
        exit=5;
    }//GEN-LAST:event_userAccountMousePressed

    private void auditTrailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_auditTrailMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,homePage,false);
        hidePanelGroup(accountSettingPage,userAccountPage,deleteLibrarianPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(settingBtn,workLogPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        
        exit=8;
    }//GEN-LAST:event_auditTrailMousePressed

    private void addUser1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUser1MousePressed
        setRandom();
        workStatus="Access Authentication Code";
        setStatus(workStatus);
        JOptionPane.showMessageDialog(null,"Your regitration code is "+code,"Athentication Code",1);
        insertRandomCode();
        
    }//GEN-LAST:event_addUser1MousePressed
    

    
    
    private void addAdminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAdminMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,homePage,false);
        hidePanelGroup(accountSettingPage,userAccountPage,deleteLibrarianPage,false);
        hidePanelGroup(workLogPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(settingBtn,createAdminPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        
        exit=6;
    }//GEN-LAST:event_addAdminMousePressed

    private void userListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userListMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,reportHistoryPage,homePage,false);
        hidePanelGroup(accountSettingPage,userAccountPage,createAdminPage,false);
        hidePanelGroup(workLogPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,user,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(settingBtn,deleteLibrarianPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(reportButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        exit=7;
        categoryType.setSelectedIndex(0);
        setUserList();
    }//GEN-LAST:event_userListMousePressed

    private void back1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back1MousePressed
        setBackArrow();
    }//GEN-LAST:event_back1MousePressed

    private void back3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back3MousePressed
        setBackArrow();
    }//GEN-LAST:event_back3MousePressed

    private void back4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back4MousePressed
        setBackArrow();
    }//GEN-LAST:event_back4MousePressed

    private void back5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back5MousePressed
        setBackArrow();
    }//GEN-LAST:event_back5MousePressed

    private void addMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMousePressed
        String book_id=bookId.getText();
        String book_category=(String)bookCategory.getSelectedItem();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
            
            ps=conn.prepareStatement("select bookId from db_booklist where bookId=?");
            ps.setString(1,book_id);
            rs=ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"This book is already added");
                title.setText("");
                author.setText("");
                bookCategory.setSelectedIndex(0);
            }
            else{
                if(title.getText().isEmpty()||author.getText().isEmpty()
                ||book_category.equals("Select Category")){
                    
                    JOptionPane.showMessageDialog(null,"Fill all information needed!");
                    title.setText("");
                    author.setText("");
                    bookCategory.setSelectedIndex(0);
                }
                else{
                    setAddBook();
                    workStatus="Add Books";
                    setStatus(workStatus);
                }
            }
            
            
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addMousePressed

    private void deleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMousePressed
        if(select==-1){
            JOptionPane.showMessageDialog(null, "Please select atleast one book!","Error",0);
            setBookList();
            select=-1;
        }
        else{
            
            if(quantity==0){
                JOptionPane.showMessageDialog(null,"This book is not available for deleting!","Error",0);
                setBookList();
                select=-1;
            }
            else if(quantity>=1){
                int bookQuan=quantity+borrowQuan;
                
                int booksNum=Integer.parseInt(JOptionPane.showInputDialog(null,"How many books do you want to delete? \n There is "
                        + " "+quantity+" available","Message",3));
            
                if(booksNum<quantity){
                    
                    int choice=JOptionPane.showConfirmDialog(null,"Do you realy want to delete this book?","Message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    
                    if(choice==JOptionPane.YES_OPTION){
                        
                        int minus=quantity-booksNum;
                        int plus=borrowQuan; 
                        
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                            ps=conn.prepareStatement("update db_booklist set returnBook=?, issueBook=? where bookId=?");
                            ps.setInt(1,minus);
                            ps.setInt(2,plus);
                            ps.setString(3,bookIDS);
                            ps.executeUpdate();

                            setBookList();
                            workStatus="Delete Books";
                            setStatus(workStatus);
                            JOptionPane.showMessageDialog(null,"Deleted Succesful");

                        }
                        catch (ClassNotFoundException ex) {
                            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        catch (SQLException ex) {
                            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null,"The book will be not deleted!","Message",1);
                        setBookList();
                        select=-1;
                    }
                    
                    
                }
                
                else if(booksNum>quantity){
                    JOptionPane.showMessageDialog(null,"You exceed to minimum available number of books!","Error",0);
                    setBookList();
                    select=-1;
                }
                
                else if(quantity==bookQuan&&booksNum==quantity){
                    
                    int choice=JOptionPane.showConfirmDialog(null,"Do you realy want to delete this book?","Message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

                    if(choice==JOptionPane.YES_OPTION){
                            
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                            int row=bookTable.getSelectedRow();
                            String value=(bookTable.getModel().getValueAt(row,0).toString());

                            ps=conn.prepareStatement("delete from db_booklist where bookId=?");
                            ps.setString(1,value);
                            ps.executeUpdate();

                            setBookList();
                            workStatus="Delete Books";
                            setStatus(workStatus);
                            JOptionPane.showMessageDialog(null,"Deleted Succesful");
                            
                        }
                        catch (ClassNotFoundException ex) {
                                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        catch (SQLException ex) {
                                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"The book will be not deleted!","Message",1);
                        setBookList();
                        select=-1;
                    }
                }
                else if(booksNum==quantity){
                    int choice=JOptionPane.showConfirmDialog(null,"Do you realy want to delete this book?","Message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    
                    if(choice==JOptionPane.YES_OPTION){
                        
                        int minus=quantity-booksNum;
                        int plus=borrowQuan; 
                        
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                            ps=conn.prepareStatement("update db_booklist set returnBook=?, issueBook=? where bookId=?");
                            ps.setInt(1,minus);
                            ps.setInt(2,plus);
                            ps.setString(3,bookIDS);
                            ps.executeUpdate();

                            setBookList();
                            workStatus="Delete Books";
                            setStatus(workStatus);
                            JOptionPane.showMessageDialog(null,"Deleted Succesful");

                        }
                        catch (ClassNotFoundException ex) {
                            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        catch (SQLException ex) {
                            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null,"The book will be not deleted!","Message",1);
                        setBookList();
                        select=-1;
                    }
                }
            }

                
            
        }
                
    }//GEN-LAST:event_deleteMousePressed

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

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        search=searchBar.getText();
        bookCategories=(String)category.getSelectedItem();
        
        if(bookCategories.equals("Select Category")){
            setSearchBook();
        }
        else{
            setSearchBookCat();
        }
    }//GEN-LAST:event_searchBarKeyReleased
    
    
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
    
    int bookAvail;
    
    
    
    private void returnWindow1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnWindow1MousePressed
        
        if(returnStudentId.getText().isEmpty()||returnStudentName.getText().isEmpty()||
            returnYearSection.getText().isEmpty()||returnBookID.getText().isEmpty()||
            returnTitle.getText().isEmpty()||returnAuthor.getText().isEmpty()||
            returnCategory.getText().isEmpty()||issuedDate.getText().isEmpty()||
            returnDate.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null,"Please all information needed");
                
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

    
    
    private void bookHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookHistoryActionPerformed
        book_history=(String)bookHistory.getSelectedItem();
        search_history=searchBookHistory.getText();

        if(book_history.equals("Book History")){
            setReportList();
            searchBookHistory.setText("");
        }
        else{
            showBookHistory(book_history);
            searchBookHistory.setText("");
            
        }
    }//GEN-LAST:event_bookHistoryActionPerformed

    private void searchBookHistoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBookHistoryKeyReleased
        book_history=(String)bookHistory.getSelectedItem();
        search_history=searchBookHistory.getText();
        
        if(book_history.equals("Book History")){
            searchReport();
        }
        else{
            searchReportCat();
        }
    }//GEN-LAST:event_searchBookHistoryKeyReleased

    private void detailBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailBtnMousePressed
        exit=9;
        
        if(selectReport==-1){
            JOptionPane.showMessageDialog(null, "Please select atleast one book!","Error",0);
        }
        else {
            setReportDetails(); 
            setDetails();
        }
    }//GEN-LAST:event_detailBtnMousePressed

    private void back6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back6MousePressed
        setBackArrow();
        exit=10;
    }//GEN-LAST:event_back6MousePressed

    String historyReport;
    private void reportTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportTableMouseClicked
        DefaultTableModel model=(DefaultTableModel)reportTable.getModel();
        selectReport=reportTable.getSelectedRow();
        selectReport++;
        historyReport="TRANS"+String.format("%03d",selectReport);
        
    }//GEN-LAST:event_reportTableMouseClicked

    private void delete1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete1MousePressed
        int choice=JOptionPane.showConfirmDialog(null,"Do you realy want to delete this account?","Message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(choice==JOptionPane.YES_OPTION){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                int row=userTable.getSelectedRow();
                String value=(userTable.getModel().getValueAt(row,0).toString());

                ps=conn.prepareStatement("delete from db_signup where id=?");
                ps.setString(1,value);
                ps.executeUpdate();

                setUserList();
                workStatus="Delete User";
                setStatus(workStatus);
                JOptionPane.showMessageDialog(null,"Deleted Succesful");
            }
            catch (ClassNotFoundException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"This account will not be deleted","Message",1);
        }
        
    }//GEN-LAST:event_delete1MousePressed

    private void adminSignUpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminSignUpMousePressed
        
        if(admin_lname.getText().isEmpty()||admin_fname.getText().isEmpty()||admin_mname.getText().isEmpty()||
           admin_age.getText().isEmpty()||admin_gender.getText().isEmpty()||admin_address.getText().isEmpty()||
           admin_number.getText().isEmpty()||admin_email.getText().isEmpty()||admin_position.getText().isEmpty()||
           admin_user.getText().isEmpty()||admin_pass.getText().isEmpty()||admin_conpass.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Fill all information needed!","Error",0);
            admin_lname.setText("");
            admin_fname.setText("");
            admin_mname.setText("");
            admin_age.setText("");
            admin_gender.setText("");
            admin_address.setText("");
            admin_number.setText("");
            admin_email.setText("");
            admin_position.setText("");
            admin_user.setText("");
            admin_pass.setText("");
            admin_conpass.setText("");
        }
        else if(admin_age.getText().length()>=3){
            JOptionPane.showMessageDialog(null,"The age is too much!","Error",0);
            admin_age.setText("");
        }
        else if(admin_number.getText().length()>11||admin_number.getText().length()<11){
            JOptionPane.showMessageDialog(null,"The number must be exact 11!","Error",0);
            admin_number.setText("");
        }
        else if(!admin_pass.getText().equals(admin_conpass.getText())){
                JOptionPane.showMessageDialog(null,"Password Does'nt Match!","Error",0);
                admin_pass.setText("");
                admin_conpass.setText("");
        }
        else if(admin_pass.getText().length()<6){
            if(admin_pass.getText().equals(admin_conpass.getText())){
                JOptionPane.showMessageDialog(null,"Password too short","Error",0);
            }
        }
        else if(admin_pass.getText().length()>=6){
            if(admin_pass.getText().equals(admin_conpass.getText())){
                getTblName();
            }
        }
    }//GEN-LAST:event_adminSignUpMousePressed

    private void admin_ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admin_ageKeyTyped
        char c= evt.getKeyChar();
        if(Character.isLetter(c)){
            admin_age.setEditable(false);
        }
        else{
            if(admin_age.getText().length()<=2){
                admin_age.setEditable(true);
            }
            else{
                admin_age.setEditable(false);
            }
        }
    }//GEN-LAST:event_admin_ageKeyTyped

    private void admin_ageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admin_ageFocusGained
        admin_age.setEditable(true);
    }//GEN-LAST:event_admin_ageFocusGained

    private void admin_ageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admin_ageFocusLost
        admin_age.setEditable(true);
    }//GEN-LAST:event_admin_ageFocusLost

    private void admin_numberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admin_numberKeyTyped
        char d= evt.getKeyChar();
        if(Character.isLetter(d)){
            admin_number.setEditable(false);
        }
        else{
            if(admin_number.getText().length()<=11){
                admin_number.setEditable(true);
            }
            else{
                admin_number.setEditable(false);
            }
        }
    }//GEN-LAST:event_admin_numberKeyTyped

    private void admin_numberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admin_numberFocusGained
        admin_number.setEditable(true);
    }//GEN-LAST:event_admin_numberFocusGained

    private void admin_numberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admin_numberFocusLost
        admin_number.setEditable(true);
    }//GEN-LAST:event_admin_numberFocusLost
    
    private void searchUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchUserKeyReleased
        userType=(String)categoryType.getSelectedItem();
        searchUsers=searchUser.getText();
        
        if(userType.equals("Select Type")){
            setSearchUsers();
        }
        else{
            searchUserType();
        }
    }//GEN-LAST:event_searchUserKeyReleased

    private void categoryTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryTypeActionPerformed
        userType=(String)categoryType.getSelectedItem();
        searchUsers=searchUser.getText();

        if(userType.equals("Select Type")){
            showUserList();
            searchUser.setText("");
        }
        else{
            showUserListType(userType);
            searchUser.setText("");
            
        }
    }//GEN-LAST:event_categoryTypeActionPerformed

    private void returnStudentIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnStudentIdKeyReleased
        String getStdID=returnStudentId.getText();
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
    }//GEN-LAST:event_returnStudentIdKeyReleased

    private void returnStudentIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnStudentIdKeyTyped
        if(evt.getKeyChar()==evt.VK_BACK_SPACE){
            returnStudentName.setText("");
            returnYearSection.setText("");
        }
    }//GEN-LAST:event_returnStudentIdKeyTyped

    private void back7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back7MousePressed
        setBackArrow();
    }//GEN-LAST:event_back7MousePressed

    private void back8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back8MousePressed
        setBackArrow();
    }//GEN-LAST:event_back8MousePressed

    private void transHistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transHistoryMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,homePage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,user,inventory,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(reportButton,reportHistoryPage);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        setReportList();
        selectReport=-1;
        bookHistory.setSelectedIndex(0);
        exit=10;
    }//GEN-LAST:event_transHistoryMousePressed

    private void bookInventoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookInventoryMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,homePage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,user,reportHistoryPage,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(reportButton,inventory);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        
        exit=11;
        selectAction.setSelectedIndex(0);
        selectHistoryDate.setSelectedIndex(0);
        setTotalBooks();
    }//GEN-LAST:event_bookInventoryMousePressed

    private void libUsersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libUsersMousePressed
        hidePanelGroup(bookListPage,transactionPage,issueBookPage,false);
        hidePanelGroup(returnBookPage,homePage,accountSettingPage,false);
        hidePanelGroup(userAccountPage,deleteLibrarianPage,workLogPage,false);
        hidePanelGroup(createAdminPage,aboutPage,detailsPage,false);
        hidePanelGroup(reports,inventory,reportHistoryPage,false);
        hidePanelGroup(issueBooksPage,inventory,user,false);
        setActive(reportButton,user);
        setBtnHover(bookListButton, 134, 191, 230);
        setBtnHover(transactionButton, 134, 191, 230);
        setBtnHover(dashboardBtn, 134, 191, 230);
        setBtnHover(settingBtn, 134, 191, 230);
        setBtnHover(aboutBtn, 134, 191, 230);
        exit=12;
        usersTotal.setText("");
    }//GEN-LAST:event_libUsersMousePressed

    private void back9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back9MousePressed
        setBackArrow();
    }//GEN-LAST:event_back9MousePressed

    private void selectActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionActionPerformed
        action=(String)selectAction.getSelectedItem();
        
        if(action.equals("Select Action")){
            DefaultTableModel model=(DefaultTableModel)bInventory.getModel();
            model.setRowCount(0);
            bInventory.setModel(model);
            selectHistoryDate.removeAllItems();
            selectHistoryDate.addItem("Select History Date");
            selectHistoryDate.setSelectedIndex(0);
        }
        else if(action.equals("Issue Book")){
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select date from db_history where action=? group by date order by date ");
                ps.setString(1,"Issue Book");
                rs=ps.executeQuery();
                
                selectHistoryDate.removeAllItems();
                selectHistoryDate.addItem("Select History Date");
                selectHistoryDate.setSelectedIndex(0);
                
                while(rs.next()){
                    selectHistoryDate.addItem(rs.getString("date"));
                }
                
            }
            catch (ClassNotFoundException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(action.equals("Return Book")){
            selectHistoryDate.setSelectedIndex(0);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select duedate from db_history where action=? group by duedate order by duedate ");
                ps.setString(1,"Return Book");
                rs=ps.executeQuery();
                
                selectHistoryDate.removeAllItems();
                selectHistoryDate.addItem("Select History Date");
                selectHistoryDate.setSelectedIndex(0);
                while(rs.next()){
                    selectHistoryDate.addItem(rs.getString("duedate"));
                }
                
            }
            catch (ClassNotFoundException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_selectActionActionPerformed

    private void selectHistoryDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectHistoryDateActionPerformed
        history=(String)selectHistoryDate.getSelectedItem();
        action=(String)selectAction.getSelectedItem();

        if(action.equals("Issue Book")){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select date from db_history where action=? group by date order by date asc");
                ps.setString(1,"Issue Book");
                rs=ps.executeQuery();

                selectHistoryDate.removeAllItems();
                selectHistoryDate.addItem("Select History Date");
                
                while(rs.next()){
                    selectHistoryDate.addItem(rs.getString("date"));
                }
                selectHistoryDate.setSelectedItem(history);
                
            }
            catch (ClassNotFoundException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            setInventoryBook("date");
        }
        else if(action.equals("Return Book")){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select duedate from db_history where action=? group by duedate order by duedate asc");
                ps.setString(1,"Return Book");
                rs=ps.executeQuery();
                
                selectHistoryDate.removeAllItems();
                selectHistoryDate.addItem("Select History Date");
                
                while(rs.next()){
                    selectHistoryDate.addItem(rs.getString("duedate"));
                }
                selectHistoryDate.setSelectedItem(history);
                
            }   
            catch (ClassNotFoundException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            setInventoryBook("duedate");
        }

    }//GEN-LAST:event_selectHistoryDateActionPerformed

    private void backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMousePressed
        setBackArrow();
    }//GEN-LAST:event_backMousePressed

    private void issueWindow1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueWindow1MousePressed

        if(issueStudentId.getText().isEmpty()||issueStudentName.getText().isEmpty()||
            issueYearSection.getText().isEmpty()||issueBookID.getText().isEmpty()||
            issueTitle.getText().isEmpty()||issueAuthor.getText().isEmpty()||
            issueCategory.getText().isEmpty()||issueDate.getText().isEmpty()||
            issueDueDate.getText().isEmpty()){

            JOptionPane.showMessageDialog(null,"Please all information needed");
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
                JOptionPane.showMessageDialog(null,"Issued book sucessful");
            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_issueWindow1MousePressed

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
    
    
    private void libUserDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libUserDateActionPerformed
        chbxDate=(String)libUserDate.getSelectedItem();
        chbxCourse=(String)libUserCourse.getSelectedItem();
        
        if(chbxDate.equals("Select All Dates")&&chbxCourse.equals("Select All Courses")){
            DefaultTableModel model=(DefaultTableModel)libUserTable.getModel();
            model.setRowCount(0);
            libUserTable.setModel(model);
            
        }
        else if(chbxCourse.equals("Select All Courses")){
            setLibraryUserData();
            getTotalLibUser();
        }
    }//GEN-LAST:event_libUserDateActionPerformed

    private void libUserCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libUserCourseActionPerformed
        chbxDate=(String)libUserDate.getSelectedItem();
        chbxCourse=(String)libUserCourse.getSelectedItem();
        
        if(chbxDate.equals("Select All Dates")&&chbxCourse.equals("Select All Courses")){
            setLibraryUser();
            getTotalLibUser();
        }
        else if(chbxCourse.equals("Select All Courses")){
            setLibraryUserData();
            getTotalLibUser();
        }
        else{
            DisplayUserData();
            getTotalLibUser();
        }
    }//GEN-LAST:event_libUserCourseActionPerformed

    private void libUserDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_libUserDateFocusGained
//        setUpdateChbxUser();
    }//GEN-LAST:event_libUserDateFocusGained

    private void back10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back10MousePressed
        setBackArrow();
    }//GEN-LAST:event_back10MousePressed

    private void issueWindow2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueWindow2MousePressed
        if(issuesStdId.getText().isEmpty()||issuesStdName.getText().isEmpty()||issuesYS.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Fill all information needed","Error",0);
            issuesStdId.setText("");
            issuesStdName.setText("");
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
            issuesStdName.setText("");
            issuesYS.setText("");    
            
            workStatus="Issue Book";
            setStatus(workStatus);
            
            JOptionPane.showMessageDialog(null,"Issued book sucessful","Message",1);
        }
        
    }//GEN-LAST:event_issueWindow2MousePressed
    
    private void logo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo1MousePressed
        System.exit(0);
    }//GEN-LAST:event_logo1MousePressed

    String log;
    private void logDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logDateActionPerformed
        log=(String)logDate.getSelectedItem();
        
        if(log.equals("Select Date")){
            DefaultTableModel model1=(DefaultTableModel)workLogTable.getModel();
            model1.setRowCount(0);
            workLogTable.setModel(model1);
        }
        else{
            setLogDate(log);

        }
    }//GEN-LAST:event_logDateActionPerformed

    private void issueStudentIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_issueStudentIdKeyReleased
        String getStdID=issueStudentId.getText();
        if(numChoice.equals("1")){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost/library","root","");

                ps=conn.prepareStatement("select * from db_libraryusers where studentNo=? ");
                ps.setString(1,issueStudentId.getText());
                rs=ps.executeQuery();

                if(rs.next()){
                    issueStudentId.setText(rs.getString("studentNo"));
                    issueStudentName.setText(rs.getString("name"));
                    issueYearSection.setText(rs.getString("section"));
                }
                else{
                    if(returnStudentId.getText().length()==10){
                        JOptionPane.showMessageDialog(null,"This Student ID is not register as the borrower of this book!","Error",0);
                        issueStudentName.setText("");
                        issueYearSection.setText("");
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
    }//GEN-LAST:event_issueStudentIdKeyReleased

    private void logo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo2MousePressed
        this.setExtendedState(homepage.ICONIFIED);
    }//GEN-LAST:event_logo2MousePressed

    int choose;    
    
    


    
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
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new homepage().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pic;
    private javax.swing.JLabel about;
    private javax.swing.JPanel aboutBtn;
    private javax.swing.JLabel aboutIcon;
    private javax.swing.JPanel aboutPage;
    private javax.swing.JPanel account;
    private javax.swing.JPanel accountSettingPage;
    private javax.swing.JLabel add;
    private javax.swing.JPanel addAdmin;
    private javax.swing.JPanel addUser1;
    private javax.swing.JLabel adminSignUp;
    private javax.swing.JTextField admin_address;
    private javax.swing.JTextField admin_age;
    private javax.swing.JPasswordField admin_conpass;
    private javax.swing.JTextField admin_email;
    private javax.swing.JTextField admin_fname;
    private javax.swing.JTextField admin_gender;
    private javax.swing.JTextField admin_lname;
    private javax.swing.JTextField admin_mname;
    private javax.swing.JTextField admin_number;
    private javax.swing.JPasswordField admin_pass;
    private javax.swing.JTextField admin_position;
    private javax.swing.JTextField admin_user;
    private javax.swing.JPanel auditTrail;
    private javax.swing.JTextField author;
    private javax.swing.JTable bInventory;
    private javax.swing.JLabel back;
    private javax.swing.JLabel back1;
    private javax.swing.JLabel back10;
    private javax.swing.JLabel back2;
    private javax.swing.JLabel back3;
    private javax.swing.JLabel back4;
    private javax.swing.JLabel back5;
    private javax.swing.JLabel back6;
    private javax.swing.JLabel back7;
    private javax.swing.JLabel back8;
    private javax.swing.JLabel back9;
    private javax.swing.JLabel backgroundDesign;
    private javax.swing.JLabel bgBlack;
    private javax.swing.JLabel bgBlack10;
    private javax.swing.JLabel bgBlack11;
    private javax.swing.JLabel bgBlack12;
    private javax.swing.JLabel bgBlack13;
    private javax.swing.JLabel bgBlack14;
    private javax.swing.JLabel bgBlack15;
    private javax.swing.JLabel bgBlack16;
    private javax.swing.JLabel bgBlack17;
    private javax.swing.JLabel bgBlack2;
    private javax.swing.JLabel bgBlack3;
    private javax.swing.JLabel bgBlack4;
    private javax.swing.JLabel bgBlack5;
    private javax.swing.JLabel bgBlack6;
    private javax.swing.JLabel bgBlack7;
    private javax.swing.JLabel bgBlack8;
    private javax.swing.JLabel bgBlack9;
    private javax.swing.JLabel bgPic;
    private javax.swing.JPanel body;
    private javax.swing.JComboBox<String> bookCategory;
    private javax.swing.JComboBox<String> bookHistory;
    private javax.swing.JTextField bookId;
    private javax.swing.JPanel bookInventory;
    private javax.swing.JPanel bookListButton;
    private javax.swing.JPanel bookListPage;
    private javax.swing.JTable bookTable;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JComboBox<String> categoryType;
    private javax.swing.JPanel createAdminPage;
    private javax.swing.JPanel dashboardBtn;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel delete1;
    private javax.swing.JPanel deleteLibrarianPage;
    private javax.swing.JLabel descrip10;
    private javax.swing.JLabel descrip11;
    private javax.swing.JLabel descrip12;
    private javax.swing.JLabel descrip13;
    private javax.swing.JLabel descrip14;
    private javax.swing.JLabel descrip15;
    private javax.swing.JLabel descrip16;
    private javax.swing.JLabel descrip17;
    private javax.swing.JLabel descrip18;
    private javax.swing.JLabel descrip9;
    private javax.swing.JLabel description;
    private javax.swing.JPanel descriptionBackground;
    private javax.swing.JLabel detailBtn;
    private javax.swing.JPanel details;
    private javax.swing.JPanel detailsPage;
    private javax.swing.JTextField details_SY;
    private javax.swing.JTextField details_action;
    private javax.swing.JTextField details_author;
    private javax.swing.JTextField details_bookId;
    private javax.swing.JTextField details_category;
    private javax.swing.JTextField details_date;
    private javax.swing.JTextField details_due;
    private javax.swing.JLabel details_dueDate;
    private javax.swing.JTextField details_name;
    private javax.swing.JTextField details_studentId;
    private javax.swing.JTextField details_title;
    private javax.swing.JLabel green2;
    private javax.swing.JLabel green3;
    private javax.swing.JLabel green4;
    private javax.swing.JLabel green5;
    private javax.swing.JLabel home;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JPanel homePage;
    private javax.swing.JLabel id;
    private javax.swing.JLabel id1;
    private javax.swing.JLabel id2;
    private javax.swing.JPanel inventory;
    private javax.swing.JTextField issueAuthor;
    private javax.swing.JPanel issueBookBtn;
    private javax.swing.JPanel issueBookBtn1;
    private javax.swing.JPanel issueBookBtn2;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel labelBookList;
    private javax.swing.JLabel labelBookList1;
    private javax.swing.JLabel labelBookList2;
    private javax.swing.JLabel labelBookList4;
    private javax.swing.JLabel labelIssueBook;
    private javax.swing.JLabel labelIssueBook1;
    private javax.swing.JLabel labelIssueBook2;
    private javax.swing.JComboBox<String> libUserCourse;
    private javax.swing.JComboBox<String> libUserDate;
    private javax.swing.JTable libUserTable;
    private javax.swing.JPanel libUsers;
    private javax.swing.JComboBox<String> logDate;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo1;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel logoBtn10;
    private javax.swing.JLabel logoBtn11;
    private javax.swing.JLabel logoBtn12;
    private javax.swing.JLabel logoBtn13;
    private javax.swing.JLabel logoBtn14;
    private javax.swing.JLabel logoBtn15;
    private javax.swing.JLabel logoBtn16;
    private javax.swing.JLabel logoBtn17;
    private javax.swing.JLabel logoBtn18;
    private javax.swing.JLabel logoBtn9;
    private javax.swing.JLabel logoName;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel logoutBtn;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JPanel mainBody;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel menu1;
    private javax.swing.JLabel menu2;
    private javax.swing.JLabel menuIcon;
    private javax.swing.JLabel menuIcon1;
    private javax.swing.JLabel menuIcon2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JPanel personal;
    private javax.swing.JLabel picContainer;
    private javax.swing.JLabel pink2;
    private javax.swing.JLabel pink3;
    private javax.swing.JLabel pink4;
    private javax.swing.JLabel pink5;
    private javax.swing.JLabel pink6;
    private javax.swing.JLabel pink7;
    private javax.swing.JTextField quanty;
    private javax.swing.JPanel reportButton;
    private javax.swing.JPanel reportHistoryPage;
    private javax.swing.JTable reportTable;
    private javax.swing.JPanel reports;
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
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField searchBar;
    private javax.swing.JTextField searchBookHistory;
    private javax.swing.JLabel searchLogo;
    private javax.swing.JLabel searchLogo2;
    private javax.swing.JLabel searchLogo4;
    private javax.swing.JTextField searchUser;
    private javax.swing.JComboBox<String> selectAction;
    private javax.swing.JComboBox<String> selectHistoryDate;
    private javax.swing.JLabel setting;
    private javax.swing.JPanel settingBtn;
    private javax.swing.JLabel settingIcon;
    private javax.swing.JPanel sideNav;
    private javax.swing.JPanel sidenavBtn;
    private javax.swing.JTextField title;
    private javax.swing.JLabel titleDes;
    private javax.swing.JTextField totalBooks;
    private javax.swing.JTextField totalCount;
    private javax.swing.JPanel transHistory;
    private javax.swing.JPanel transactionButton;
    private javax.swing.JPanel transactionPage;
    private javax.swing.JPanel txtFieldContainer;
    private javax.swing.JPanel txtFieldContainer2;
    private javax.swing.JPanel txtFieldContainer4;
    private javax.swing.JPanel user;
    private javax.swing.JPanel userAccount;
    private javax.swing.JPanel userAccountPage;
    private javax.swing.JPanel userList;
    private javax.swing.JTable userTable;
    private javax.swing.JLabel usersTotal;
    private javax.swing.JPanel workLogPage;
    private javax.swing.JTable workLogTable;
    private javax.swing.JLabel year;
    private javax.swing.JLabel year1;
    private javax.swing.JLabel year2;
    // End of variables declaration//GEN-END:variables
}
