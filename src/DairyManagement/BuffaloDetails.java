package DairyManagement;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BuffaloDetails extends JFrame {
     String photopath;
    JTable jTable1;
    JLabel insertLabel;
    JTextField idField, batchField, categoryField, colorField, weightField, quantityField, periodField, searchField;


    public BuffaloDetails(){

//---------------JFrame Design--------------------------------------------------------------

        //setLayout(null);
        setLayout(new BorderLayout());
        setSize(800,600);
        //setLocation(300,100);
        setLocationRelativeTo(null);
        setTitle("Buffalo Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//----------------Image For Background-------------------------------------------------------

        ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/backbuf.png"));
        JLabel imageLabel = new JLabel(backIcon);
        imageLabel.setBounds(0,0,800,600);
        add(imageLabel);

//--------------Logout Button------------------------------------------------------------------

         JButton logOut = new JButton("Back");
         logOut.setBounds(20,40, 50, 30);
         logOut.setBackground(new Color(251, 4, 4));
         logOut.setForeground(new Color(255,255,255));
         logOut.setBorder(new LineBorder(Color.WHITE, 3));
         logOut.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 setVisible(false);
                 new Start();
             }
         });
         imageLabel.add(logOut);

//---------------Next Button------------------------------------------------------------------

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(730,40, 50, 30);
        nextButton.setBackground(new Color(251, 4, 4));
        nextButton.setForeground(new Color(255,255,255));
        nextButton.setBorder(new LineBorder(Color.WHITE, 3));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CowDetails();
            }
        });
        imageLabel.add(nextButton);

//---------------Heading------------------------------------------------------------------------

        JLabel h1Label = new JLabel("Dairy Form - Buffaloes Details");
        h1Label.setBounds(200, 30, 500, 40);
        h1Label.setFont(new Font("Serif",Font.BOLD,36));
        h1Label.setForeground(new Color(0, 73, 9, 187));
        imageLabel.add(h1Label);

//---------------Heading Shadow------------------------------------------------------------------

        JLabel h1ShodoLabel = new JLabel("Dairy Form - Buffaloes Details");
        h1ShodoLabel.setBounds(202, 32, 500, 40);
        h1ShodoLabel.setFont(new Font("Serif",Font.BOLD,36));
        h1ShodoLabel.setForeground(new Color(255, 255, 255, 255));
        imageLabel.add(h1ShodoLabel);

//--------------Top Line on Frame-----------------------------------------------------------------

        JPanel line = new JPanel();
        line.setBounds(0, 85,800, 2);
        line.setBackground(new Color(0,0,0));
        imageLabel.add(line); 

//----------------ID - label and field------------------------------------------------------------

        JLabel idLabel = new JLabel("Serial No. ");
        idLabel.setBounds(30,100,150,20);
        idLabel.setFont(new Font("Serif",Font.BOLD,18));
        imageLabel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(115,95,50,22);
        idField.setFont(new Font("Serif",Font.BOLD,16));
        imageLabel.add(idField);

//----------------Batch No.- label and field-------------------------------------------------------

        JLabel batchLabel = new JLabel("Batch No. ");
        batchLabel.setBounds(530,100,150,20);
        batchLabel.setFont(new Font("Serif",Font.BOLD,18));
        imageLabel.add(batchLabel);

        batchField = new JTextField();
        batchField.setBounds(615,95,150,22);
        batchField.setFont(new Font("Serif",Font.BOLD,16));
        imageLabel.add(batchField);

//--------------Category - label and field---------------------------------------------------------

        JLabel categoryLabel = new JLabel("Category :");
        categoryLabel.setBounds(50,145,150,25);
        categoryLabel.setFont(new Font("Serif",Font.BOLD,20));
        imageLabel.add(categoryLabel);

        categoryField = new JTextField();
        categoryField.setBounds(145,145,150,25);
        categoryField.setFont(new Font("Serif",Font.BOLD,16));
        imageLabel.add(categoryField);

//----------------Color - label and field----------------------------------------------------------

        JLabel colorLabel = new JLabel("Colour :");
        colorLabel.setBounds(50,180,150,25);
        colorLabel.setFont(new Font("Serif",Font.BOLD,20));
        imageLabel.add(colorLabel);

        colorField = new JTextField();
        colorField.setBounds(145,180,150,25);
        colorField.setFont(new Font("Serif",Font.BOLD,16));
        imageLabel.add(colorField);

//--------------Weight - label and field------------------------------------------------------------

        JLabel weightLabel = new JLabel("Weight :");
        weightLabel.setBounds(50,215,150,25);
        weightLabel.setFont(new Font("Serif",Font.BOLD,20));
        imageLabel.add(weightLabel);

        weightField = new JTextField();
        weightField.setBounds(145,215,150,25);
        weightField.setFont(new Font("Serif",Font.BOLD,16));
        imageLabel.add(weightField);

//----------Quantity - label and field--------------------------------------------------------------

        JLabel quantityLabel = new JLabel("Milk Quantity :");
        quantityLabel.setBounds(50,250,150,25);
        quantityLabel.setFont(new Font("Serif",Font.BOLD,20));
        imageLabel.add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(185,250,110,25);
        quantityField.setFont(new Font("Serif",Font.BOLD,16));
        imageLabel.add(quantityField);

//------------period - label and field--------------------------------------------------------------

        JLabel PeriodLabel = new JLabel("Pregnancy Periods for Buffalo :");
        PeriodLabel.setBounds(50,285,270,25);
        PeriodLabel.setFont(new Font("Serif",Font.BOLD,20));
        imageLabel.add(PeriodLabel);

        periodField = new JTextField();
        periodField.setBounds(50,310,250,25);
        periodField.setFont(new Font("Serif",Font.BOLD,16));
        imageLabel.add(periodField);

//--------------Bottom line-----------------------------------------------------------------------

        JPanel line2 = new JPanel();
        line2.setBounds(0, 355,800, 2);
        line2.setBackground(new Color(0,0,0));
        imageLabel.add(line2);

//---------Photo Area-insert photo----------------------------------------------------------------

        JLabel photoLabel = new JLabel("Photo/Buffalo Image");
        photoLabel.setBounds(580,130, 200, 25);
        photoLabel.setFont(new Font("Serif",Font.BOLD,20));
        imageLabel.add(photoLabel);


        insertLabel = new JLabel();
        insertLabel.setBounds(620, 165, 150,150);
        insertLabel.setPreferredSize(new Dimension(150, 150));
        insertLabel.setOpaque(true);
        imageLabel.add(insertLabel);

//-------------------Search - label and field------------------------------------------------------

        JLabel searchLabel = new JLabel("Search Buffalo (ID No.) :");
        searchLabel.setBounds(385, 320, 350, 25);
        searchLabel.setFont(new Font("Serif",Font.BOLD,20));
        imageLabel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(620,320,150,25);
        searchField.setFont(new Font("Serif",Font.BOLD,16));
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //ArrayList<BuffaloBean> al = null;
                ArrayList<BuffaloBean> al = new ArrayList<>();
                String valu = searchField.getText().toString();

                try{

                    DatabaseConnection dbConnection = new DatabaseConnection();
                    Connection conn = dbConnection.getConnection();

                    String qry = "SELECT * FROM bufelo WHERE id LIKE '%" + valu + "%'";

                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(qry);

                    BuffaloBean buffaloBean;

                    while(rs.next()){

                        buffaloBean = new BuffaloBean(rs.getInt(1), rs.getString("category"), rs.getString("color"),
                                rs.getString("weight"), rs.getString("batch"), rs.getString("milk_quantity"),
                                rs.getString("pregnancy_period"), rs.getBytes("image"));
                        al.add(buffaloBean);
                    }

                    DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
                    model.setRowCount(0);
                    Object [] row = new Object[8];
                    for(int i = 0; i < al.size(); i++ ) {

                        row[0] = al.get(i).getId();
                        row[1] = al.get(i).getCategory();
                        row[2] = al.get(i).getColor();
                        row[3] = al.get(i).getWeight();
                        row[4] = al.get(i).getBatch();
                        row[5] = al.get(i).getMilkQuantity();
                        row[6] = al.get(i).getPregnancyPeriod();
                        row[7] = al.get(i).getPhoto();
                        model.addRow(row);

                    }
                }catch(Exception exception){

                    exception.printStackTrace();
                }
            }
        });
        imageLabel.add(searchField);

        //buttons----------------------------

//------------new button and action event-----------------------------------------------------------

        JButton added = new JButton("NEW");
        added.setBounds(370,95,100,30);
        added.setBackground(new Color(0, 73, 9, 187));
        added.setForeground(new Color(255,255,255));
        added.setBorder(new LineBorder(Color.WHITE, 3));
        added.setFont(new Font("Serif",Font.BOLD,16));
        added.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                idField.setText("");
                batchField.setText("");
                categoryField.setText("");
                colorField.setText("");
                weightField.setText("");
                quantityField.setText("");
                periodField.setText("");
                searchField.setText("");
                insertLabel.setIcon(null);


            }
        });
        imageLabel.add(added);

//--------------Save Button and Action Event----------------------------------------------------------

        JButton save = new JButton("SAVE");
        save.setBounds(370, 135, 100, 30);
        save.setBackground(new Color(0, 73, 9, 187));
        save.setForeground(new Color(255, 255, 255));
        save.setBorder(new LineBorder(Color.WHITE, 3));
        save.setFont(new Font("Serif", Font.BOLD, 16));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any required field is empty
                if (batchField.getText().isEmpty() ||
                        categoryField.getText().isEmpty() ||
                        colorField.getText().isEmpty() ||
                        weightField.getText().isEmpty() ||
                        quantityField.getText().isEmpty() ||
                        periodField.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "All fields are required.");
                } else {
                    try {
                        // Getting the database connection
                        DatabaseConnection dbConnection = new DatabaseConnection();
                        Connection conn = dbConnection.getConnection();

                        String qry;
                        PreparedStatement statement;

                        // If an image is selected (photopath is not empty)
                        if (photopath != null && !photopath.isEmpty()) {
                            // If image is selected, save it to the database
                            InputStream is = new FileInputStream(new File(photopath));  // Image as input stream
                            qry = "INSERT INTO bufelo(batch, category, color, weight, milk_quantity, pregnancy_period, image) VALUES(?,?,?,?,?,?,?)";
                            statement = conn.prepareStatement(qry);
                            statement.setString(1, batchField.getText());
                            statement.setString(2, categoryField.getText());
                            statement.setString(3, colorField.getText());
                            statement.setString(4, weightField.getText());
                            statement.setString(5, quantityField.getText());
                            statement.setString(6, periodField.getText());
                            statement.setBlob(7, is);  // Set the image in the statement
                        } else {
                            // If no image is selected, insert without image
                            qry = "INSERT INTO bufelo(batch, category, color, weight, milk_quantity, pregnancy_period) VALUES(?,?,?,?,?,?)";
                            statement = conn.prepareStatement(qry);
                            statement.setString(1, batchField.getText());
                            statement.setString(2, categoryField.getText());
                            statement.setString(3, colorField.getText());
                            statement.setString(4, weightField.getText());
                            statement.setString(5, quantityField.getText());
                            statement.setString(6, periodField.getText());
                        }
 
                        // Execute the insert query
                        int res = statement.executeUpdate();
                        fillTable();  // Refresh the table with updated data

                        if (res >= 1) {
                            JOptionPane.showMessageDialog(null, "Buffalo details saved successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Operation failed.");
                        }

                        // Clear all fields after saving
                        batchField.setText("");
                        categoryField.setText("");
                        colorField.setText("");
                        weightField.setText("");
                        quantityField.setText("");
                        periodField.setText("");
                        photopath = null;  // Reset the image path after saving

                    } catch (Exception e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Database connection failed.");
                    }
                }
            }
        });

        imageLabel.add(save);  // Add the save button to the image label



//----------Update Button and Action Events---------------------------------------------------------------------

        JButton update = new JButton("UPDATE");
        update.setBounds(370, 175, 100, 30);
        update.setBackground(new Color(0, 73, 9, 187));
        update.setForeground(new Color(255, 255, 255));
        update.setBorder(new LineBorder(Color.WHITE, 3));
        update.setFont(new Font("Serif", Font.BOLD, 16));
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if all required fields are filled
                if (batchField.getText().isEmpty() || categoryField.getText().isEmpty() || colorField.getText().isEmpty() ||
                        weightField.getText().isEmpty() || quantityField.getText().isEmpty() || periodField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required.");
                    return;
                }

                String qry = null;
                PreparedStatement statement = null;
                DatabaseConnection dbConnection = new DatabaseConnection();

                // Check if image is selected (photopath is not empty)
                if (photopath != null && !photopath.isEmpty()) {
                    try {
                        InputStream is = new FileInputStream(new File(photopath));  // Get the image as input stream
                        qry = "UPDATE bufelo SET batch=?, category=?, color=?, weight=?, milk_quantity=?, pregnancy_period=?, image=? WHERE id=?";
                        Connection conn = dbConnection.getConnection();
                        statement = conn.prepareStatement(qry);
                        statement.setString(1, batchField.getText());
                        statement.setString(2, categoryField.getText());
                        statement.setString(3, colorField.getText());
                        statement.setString(4, weightField.getText());
                        statement.setString(5, quantityField.getText());
                        statement.setString(6, periodField.getText());
                        statement.setBlob(7, is); // Update image
                        statement.setInt(8, Integer.parseInt(idField.getText()));

                        int res = statement.executeUpdate();
                        fillTable();  // Refresh table data

                        if (res >= 1) {
                            JOptionPane.showMessageDialog(null, "Buffalo Detail updated successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Update Operation failed.");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Database connection failed.");
                    }
                } else {
                    // Handle the case where no image is selected
                    try {
                        qry = "UPDATE bufelo SET batch=?, category=?, color=?, weight=?, milk_quantity=?, pregnancy_period=? WHERE id=?";
                        Connection conn = dbConnection.getConnection();
                        statement = conn.prepareStatement(qry);
                        statement.setString(1, batchField.getText());
                        statement.setString(2, categoryField.getText());
                        statement.setString(3, colorField.getText());
                        statement.setString(4, weightField.getText());
                        statement.setString(5, quantityField.getText());
                        statement.setString(6, periodField.getText());
                        statement.setInt(7, Integer.parseInt(idField.getText()));

                        int res = statement.executeUpdate();
                        fillTable();  // Refresh table data

                        if (res >= 1) {
                            JOptionPane.showMessageDialog(null, "Buffalo Detail updated successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Update Operation failed.");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Database connection failed.");
                    }
                }
            }
        });

        imageLabel.add(update);  // Add the update button to the image label

//---------Delete Button and Action Events---------------------------------------------------------------

        JButton delete = new JButton("DELETE");
        delete.setBounds(370,215,100,30);
        delete.setBackground(new Color(0, 73, 9, 187));
        delete.setForeground(new Color(255,255,255));
        delete.setBorder(new LineBorder(Color.WHITE, 3));
        delete.setFont(new Font("Serif",Font.BOLD,16));
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter an ID to delete.");
                } else {
                    try {
                        String qry = "delete from bufelo where id=?";
                        DatabaseConnection dbConnection = new DatabaseConnection();
                        Connection conn = dbConnection.getConnection();

                        PreparedStatement statement = conn.prepareStatement(qry);

                        // Parsing the ID as an integer and setting it in the SQL query
                        int id = Integer.parseInt(idField.getText());
                        statement.setInt(1, id);

                        int res = statement.executeUpdate();
                        fillTable();

                        if(res >= 1) {
                            JOptionPane.showMessageDialog(null, "Bufelo detail deleted successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No record found with the given ID.");
                        }

                    } catch(NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid numeric ID.");
                    } catch(Exception e2) {
                        JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
                    }
                }
            }
        });
        imageLabel.add(delete);

//------------Insert Image and Action Events--------------------------------------------------------------------

        JButton insertImage = new JButton("INSERT IMAGE");
        insertImage.setBounds(340,275,150,40);
        insertImage.setBackground(new Color(246, 0, 43, 187));
        insertImage.setForeground(new Color(255,255,255));
        insertImage.setBorder(new LineBorder(Color.WHITE, 3));
        insertImage.setFont(new Font("Serif",Font.BOLD,16));
        insertImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("*.images","jpg","png");
                chooser.addChoosableFileFilter(fnef);
                int ans = chooser.showSaveDialog(null);

                if(ans==JFileChooser.APPROVE_OPTION){
                    File selectedPhoto = chooser.getSelectedFile();
                    String path = selectedPhoto.getAbsolutePath();
                    insertLabel.setIcon(resetImageSize(path, null));
                    photopath=path;
                } else{
                    JOptionPane.showMessageDialog(null,"Image is not Found");
                }
            }
        });
        imageLabel.add(insertImage);

        //add tables-----------------------------------------------------------------------

        // Adding a table with a scroll pane
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Category");
        model.addColumn("Colour");
        model.addColumn("Weight");
        model.addColumn("Batch");
        model.addColumn("Milk-Quantity");
        model.addColumn("Pregnancy Period");
        model.addColumn("image");



        jTable1 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(jTable1);
        scrollPane.setBounds(25, 380, 750, 150);
        scrollPane.setBackground(new Color(0, 73, 9, 45));
        jTable1.setGridColor(Color.BLACK);  // Set grid color to make lines visible
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int ind = jTable1.getSelectedRow();
                showItemToField(ind);

            }
        });
        // Enable grid lines
        imageLabel.add(scrollPane);


        setVisible(true);
        //DBconnection();
        //al = new ArrayList<>();
        fillTable();

    }

//---------Insert Image Method--------------------------------------------------------------------

    public ImageIcon resetImageSize(String photopath, byte[] imageData) {
        ImageIcon imageIcon = null;

        try {
            if (photopath != null && !photopath.isEmpty()) {
                // File path se image load karna
                imageIcon = new ImageIcon(photopath);
            } else if (imageData != null) {
                // Byte array se image load karna
                imageIcon = new ImageIcon(imageData);
            }

            // Agar image load ho gayi hai, toh resize karna
            if (imageIcon != null) {
                Image image = imageIcon.getImage();
                Image resizedImage = image.getScaledInstance(insertLabel.getWidth(), insertLabel.getHeight(), Image.SCALE_SMOOTH);
                return new ImageIcon(resizedImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error resizing image: " + e.getMessage());
        }

        return null; // Agar image load nahi hui, toh null return karna
    }


//---------------Arraylist for Data retrive (methods)----------------------------------------------------

    public ArrayList<BuffaloBean> retriveData(){
        //ArrayList<BuffaloBean> al = null;
        ArrayList<BuffaloBean> al = new ArrayList<>();

        try{
            DatabaseConnection connection = new DatabaseConnection();
            Connection conn = connection.getConnection();
            String q = "SELECT * FROM bufelo";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(q);
            BuffaloBean buffaloBean;

            while(rs.next()){

                buffaloBean = new BuffaloBean(rs.getInt(1), rs.getString("category"),
                        rs.getString("color"), rs.getString("weight"), rs.getString("batch"),
                        rs.getString("milk_quantity"),
                        rs.getString("pregnancy_period"),
                        rs.getBytes("image"));

                al.add(buffaloBean);
            }

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());

        }
        return al;
    }

//----------Data Fill in table method--------------------------------------------------------------

    public void fillTable(){

        ArrayList<BuffaloBean>  al= retriveData();
        DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        Object [] row = new Object[8];
        for(int i = 0; i < al.size(); i++ ){

            row[0]=al.get(i).getId();
            row[1]=al.get(i).getCategory();
            row[2]=al.get(i).getColor();
            row[3]=al.get(i).getWeight();
            row[4]=al.get(i).getBatch();
            row[5]=al.get(i).getMilkQuantity();
            row[6]=al.get(i).getPregnancyPeriod();
            row[7]=al.get(i).getPhoto();
            model.addRow(row);

        }
    }

    public void showItemToField(int index) {
        try {
            // Text fields ko retrieveData() se set karna
            idField.setText(Integer.toString(retriveData().get(index).getId()));
            categoryField.setText(retriveData().get(index).getCategory());
            colorField.setText(retriveData().get(index).getColor());
            weightField.setText(retriveData().get(index).getWeight());
            batchField.setText(retriveData().get(index).getBatch());
            quantityField.setText(retriveData().get(index).getMilkQuantity());
            periodField.setText(retriveData().get(index).getPregnancyPeriod());

            // photopath aur image data ko retrieve karna
            //String photopath = retriveData().get(index).getPhoto(); // Assumes this method returns photopath as String
            byte[] imageData = retriveData().get(index).getPhoto(); // Assumes this method returns image data as byte[]

            // resetImageSize ko photopath aur imageData ke saath call karna
            insertLabel.setIcon(resetImageSize(photopath, imageData));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error displaying image: " + e.getMessage());
        }
    }







//    public static void main(String[] args) {
//
//        new BuffaloDetails();
//
//
//    }
}