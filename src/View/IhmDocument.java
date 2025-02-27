package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class IhmDocument extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNumEnregistrement;
    private JTextField textFieldTitre;
    private JTable table;
    private DefaultTableModel tableModel;
    private Connection connection;

    /**
     * Lancez l'application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IhmDocument frame = new IhmDocument();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Créez le cadre.
     */
    public IhmDocument() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\djobe\\Pictures\\dd.jpg"));
        setTitle("Gestion des Documents");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lblTitle = new JLabel("Documents");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitle, BorderLayout.NORTH);

        JPanel panelForm = new JPanel();
        contentPane.add(panelForm, BorderLayout.CENTER);
        GridBagLayout gbl_panelForm = new GridBagLayout();
        gbl_panelForm.columnWidths = new int[]{0, 0, 0, 0};
        gbl_panelForm.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panelForm.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_panelForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelForm.setLayout(gbl_panelForm);

        JLabel lblNumEnregistrement = new JLabel("Numéro de l'enregistrement :");
        GridBagConstraints gbc_lblNumEnregistrement = new GridBagConstraints();
        gbc_lblNumEnregistrement.insets = new Insets(0, 0, 5, 5);
        gbc_lblNumEnregistrement.anchor = GridBagConstraints.EAST;
        gbc_lblNumEnregistrement.gridx = 0;
        gbc_lblNumEnregistrement.gridy = 0;
        panelForm.add(lblNumEnregistrement, gbc_lblNumEnregistrement);

        textFieldNumEnregistrement = new JTextField();
        GridBagConstraints gbc_textFieldNumEnregistrement = new GridBagConstraints();
        gbc_textFieldNumEnregistrement.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNumEnregistrement.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNumEnregistrement.gridx = 1;
        gbc_textFieldNumEnregistrement.gridy = 0;
        panelForm.add(textFieldNumEnregistrement, gbc_textFieldNumEnregistrement);
        textFieldNumEnregistrement.setColumns(10);

        JLabel lblTitre = new JLabel("Titre :");
        GridBagConstraints gbc_lblTitre = new GridBagConstraints();
        gbc_lblTitre.anchor = GridBagConstraints.EAST;
        gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
        gbc_lblTitre.gridx = 0;
        gbc_lblTitre.gridy = 1;
        panelForm.add(lblTitre, gbc_lblTitre);

        textFieldTitre = new JTextField();
        GridBagConstraints gbc_textFieldTitre = new GridBagConstraints();
        gbc_textFieldTitre.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldTitre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTitre.gridx = 1;
        gbc_textFieldTitre.gridy = 1;
        panelForm.add(textFieldTitre, gbc_textFieldTitre);
        textFieldTitre.setColumns(10);

        JPanel panelButtons = new JPanel();
        GridBagConstraints gbc_panelButtons = new GridBagConstraints();
        gbc_panelButtons.gridwidth = 2;
        gbc_panelButtons.insets = new Insets(0, 0, 5, 0);
        gbc_panelButtons.gridx = 0;
        gbc_panelButtons.gridy = 3;
        panelForm.add(panelButtons, gbc_panelButtons);

        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAjouter.setForeground(new Color(255, 255, 255));
        btnAjouter.setBackground(new Color(50, 205, 50));
        panelButtons.add(btnAjouter);
        btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ajouterDocument();
            }
        });

        JButton btnModifier = new JButton("Modifier");
        btnModifier.setForeground(new Color(255, 255, 255));
        btnModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnModifier.setBackground(new Color(100, 149, 237));
        panelButtons.add(btnModifier);
        btnModifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modifierDocument();
            }
        });

        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setForeground(new Color(255, 255, 255));
        btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnSupprimer.setBackground(new Color(220, 20, 60));
        panelButtons.add(btnSupprimer);
        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                supprimerDocument();
            }
        });

        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.setForeground(new Color(255, 255, 255));
        btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnEnregistrer.setBackground(new Color(100, 149, 237));
        panelButtons.add(btnEnregistrer);
        btnEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enregistrerModification();
            }
        });

        JPanel panelTable = new JPanel();
        panelTable.setBorder(new TitledBorder(null, "Liste des documents", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panelTable, BorderLayout.SOUTH);

        tableModel = new DefaultTableModel(new Object[]{"Numéro de l'enregistrement", "Titre"}, 0);
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 150));
        table.setFillsViewportHeight(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = table.getSelectedRow();
                textFieldNumEnregistrement.setText(tableModel.getValueAt(selectedRow, 0).toString());
                textFieldTitre.setText(tableModel.getValueAt(selectedRow, 1).toString());
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        panelTable.add(scrollPane);

        // Connect to database
        connectToDatabase();

        // Load data from database
        loadDocuments();
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdbibliotheque", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ajouterDocument() {
        try {
            String sql = "INSERT INTO document (numEnregistrement, Titre) VALUES (?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(textFieldNumEnregistrement.getText()));
            pst.setString(2, textFieldTitre.getText());
            pst.executeUpdate();
            pst.close();
            loadDocuments();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void modifierDocument() {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String numEnregistrement = tableModel.getValueAt(selectedRow, 0).toString();
                String sql = "UPDATE document SET Titre = ? WHERE numEnregistrement = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, textFieldTitre.getText());
                pst.setInt(2, Integer.parseInt(numEnregistrement));
                pst.executeUpdate();
                pst.close();
                JOptionPane.showMessageDialog(this, "Modification effectuée avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                loadDocuments();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void supprimerDocument() {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String numEnregistrement = tableModel.getValueAt(selectedRow, 0).toString();
                String sql = "DELETE FROM document WHERE numEnregistrement = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(numEnregistrement));
                pst.executeUpdate();
                pst.close();
                loadDocuments();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void enregistrerModification() {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String numEnregistrement = textFieldNumEnregistrement.getText();
                String titre = textFieldTitre.getText();
                String sql = "UPDATE document SET Titre = ? WHERE numEnregistrement = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, titre);
                pst.setInt(2, Integer.parseInt(numEnregistrement));
                pst.executeUpdate();
                pst.close();
                JOptionPane.showMessageDialog(this, "Modifications enregistrées avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                loadDocuments();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadDocuments() {
        try {
            tableModel.setRowCount(0); // Clear existing data
            String sql = "SELECT numEnregistrement, Titre FROM document";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString("numEnregistrement"));
                row.add(rs.getString("Titre"));
                tableModel.addRow(row);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
