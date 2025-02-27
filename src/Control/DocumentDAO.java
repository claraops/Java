/*package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblio.Document;
import biblio.Livre;

public class DocumentDAO {

    public void addDocument(int numEnregistrement, String titre) throws SQLException {
        String query = "INSERT INTO document (numEnregistrement, Titre) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, numEnregistrement);
            pstmt.setString(2, titre);
            pstmt.executeUpdate();
        }
    }

    public List<Document> getAllDocuments() throws SQLException {
        List<Document> documents = new ArrayList<>();
        String query = "SELECT * FROM document";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                documents.add(new Livre(rs.getInt("numEnregistrement"), rs.getString("Titre"), query, 0));
            }
        }
        return documents;
    }

    public void updateDocument(int numEnregistrement, String titre) throws SQLException {
        String query = "UPDATE document SET Titre = ? WHERE numEnregistrement = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, titre);
            pstmt.setInt(2, numEnregistrement);
            pstmt.executeUpdate();
        }
    }

    public void deleteDocument(int numEnregistrement) throws SQLException {
        String query = "DELETE FROM document WHERE numEnregistrement = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, numEnregistrement);
            pstmt.executeUpdate();
        }
    }
}*/