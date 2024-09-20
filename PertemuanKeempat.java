package PertemuanKeempat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PertemuanKeempat {

    Connection conn;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/PBO_4";
    String user = "postgres";
    String password = "Laura12345";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public void tambah() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false); // Nonaktifkan otomatis commit

            String sql = "INSERT INTO dosen (nomor_induk_dosen, nama_dosen, tanggal_lahir, jenis_kelamin, alamat, email) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            boolean selesai = false;
            while (!selesai) {
                System.out.println("MASUKKAN DATA DOSEN ");
                System.out.print("Nomor induk dosen : ");
                String nomor_induk_dosen = input.readLine().trim();
                System.out.print("Nama : ");
                String nama_dosen = input.readLine().trim();
                System.out.print("Tanggal lahir (YYYY-MM-DD): ");
                String tanggal_lahir = input.readLine().trim();
                System.out.print("Jenis kelamin : ");
                String jenis_kelamin = input.readLine().trim();
                System.out.print("Alamat : ");
                String alamat = input.readLine().trim();
                System.out.print("Email : ");
                String email = input.readLine().trim();

                pstmt.setString(1, nomor_induk_dosen);
                pstmt.setString(2, nama_dosen);
                pstmt.setDate(3, java.sql.Date.valueOf(tanggal_lahir)); // Pastikan formatnya benar
                pstmt.setString(4, jenis_kelamin);
                pstmt.setString(5, alamat);
                pstmt.setString(6, email);
                pstmt.executeUpdate();

                System.out.print("Apakah Anda ingin memasukkan data dosen lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true; // Ubah ke true agar loop berhenti jika tidak ingin memasukkan data lagi
                }
            }

            conn.commit(); // Commit transaksi setelah sejumlah operasi-insert berhasil
            System.out.println("Sukses dalam satu penambahan data.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi insert dalam loop.");
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // Batalkan transaksi jika terjadi kesalahan
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void tampil() {
        try {
            Class.forName(driver);
            String sql = "SELECT * FROM dosen";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PertemuanKeempat.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void hapus() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);

            System.out.print("Masukkan Nomor induk dosen yang akan dihapus : ");
            String nomorIndukDosen = input.readLine().trim();

            String deleteSql = "DELETE FROM dosen WHERE nomor_induk_dosen = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, nomorIndukDosen);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Penghapusan berhasil untuk nomor induk dosen " + nomorIndukDosen + "!");
            } else {
                System.out.println("Nomor induk dosen " + nomorIndukDosen + " tidak ada.");
            }

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(PertemuanKeempat.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        try {
            Class.forName(driver);
            String sql = "UPDATE dosen SET nama_dosen = ?, tanggal_lahir = ?, jenis_kelamin = ?, alamat = ?, email = ? WHERE nomor_induk_dosen = ?";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);

            System.out.print("Masukkan nomor induk dosen yang akan diupdate : ");
            String nomorIndukDosen = input.readLine().trim();
            System.out.print("Nama dosen baru : ");
            String namaDosenBaru = input.readLine().trim();
            System.out.print("Tanggal lahir baru (YYYY-MM-DD): ");
            String tanggalLahirBaru = input.readLine().trim();
            System.out.print("Jenis kelamin baru : ");
            String jenisKelaminBaru = input.readLine().trim();
            System.out.print("Alamat baru : ");
            String alamatBaru = input.readLine().trim();
            System.out.print("Email baru : ");
            String emailBaru = input.readLine().trim();

            pstmt.setString(1, namaDosenBaru);
            pstmt.setDate(2, java.sql.Date.valueOf(tanggalLahirBaru)); // Pastikan formatnya benar
            pstmt.setString(3, jenisKelaminBaru);
            pstmt.setString(4, alamatBaru);
            pstmt.setString(5, emailBaru);
            pstmt.setString(6, nomorIndukDosen);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil diupdate.");
            } else {
                System.out.println("Data tidak ditemukan.");
            }

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(PertemuanKeempat.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n========= MENU UTAMA =========");
            System.out.println("1. Input Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Update Data");
            System.out.println("0. Keluar");
            System.out.print("PILIHAN> ");

            try {
                int pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 0:
                        exit = true; // Set exit menjadi true untuk keluar dari loop
                        break;
                    case 1:
                        tambah();
                        break;
                    case 2:
                        tampil();
                        break;
                    case 3:
                        hapus();
                        break;
                    case 4:
                        update();
                        break;
                    default:
                        System.out.println("Pilihan salah!");
                }
            } catch (IOException | NumberFormatException ex) {
                Logger.getLogger(PertemuanKeempat.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        }
        System.out.println("Program telah selesai."); // Pesan saat keluar dari program
    }

    public static void main(String[] args) {
        new PertemuanKeempat().menu();
    }
}