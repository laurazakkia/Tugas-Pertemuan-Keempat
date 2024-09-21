# Konsep Pemrograman Berbasis Obyek - Pertemuan Keempat

---

## Daftar Isi :
- [ CRUD](https://github.com/laurazakkia/Tugas-Pertemuan-Keempat/blob/main/PertemuanKeempat.java)
- [ Exception Handling](https://github.com/laurazakkia/Tugas-Pertemuan-Keempat/blob/main/CobaException.java)
- [ Custom Exception](https://github.com/laurazakkia/Tugas-Pertemuan-Keempat/blob/main/LauraException.java)

---


## CRUD
CRUD adalah istilah yang merujuk pada empat kegiatan dasar dalam mengelola informasi :  
- Create berarti menambahkan informasi baru
- Read berarti melihat atau mengambil informasi yang sudah ada
- Update berarti mengubah informasi yang sudah ada
- Delete berarti menghilangkan informasi dari sistem. 

---

## Exception Handling
Exception handling adalah mekanisme untuk menangani kesalahan atau error yang terjadi saat program berjalan. 

### Try Catch
- Try Block : Bagian ini berisi kode yang berpotensi menghasilkan exception. 
- Catch Block : Bagian ini menangkap exception yang terjadi dalam blok try.
  
### Source Code Try Catch
<pre>
  public static void main(String[] args) {
        CobaException belajar = new CobaException();

        try {
            int hasil1 = belajar.bagiBilangan(10, 0); 
            System.out.println("Hasil: " + hasil1);
        } catch (ArithmeticException e) {
            System.out.println("Error: Pembagian dengan nol tidak diperbolehkan.");
        }
    }
</pre>
- Membuat objek dari kelas CobaException dan menggunakan blok try-catch untuk menangani kemungkinan terjadinya ArithmeticException. 

### Throws
Throws adalah cara untuk meneruskan kesalahan ke pemanggil metode.

### Source Code Throws
<pre>
   public int bagiBilangan(int a, int b) throws ArithmeticException {
        return a / b; // Potensi ArithmeticException
    }
</pre>
Pada metode ini tidak ada penanganannya karena hanya menggunakan metode throws yang artinya kesalahan hanya di lempar saja tanpa di tangani. 

---

## Custom Exception
Custom exception adalah jenis exception yang dibuat untuk memenuhi kebutuhan khusus dalam sebuah aplikasi. 

## Source Code Custom 
<pre>
  public class LauraException extends ArithmeticException {

    public LauraException(String s) {
        super(s);
    }
}
</pre>
LauraException Merupakan subclass dari ArithmeticException, dirancang untuk melempar pesan kesalahan yang disesuaikan saat terjadi pembagian dengan nol.
  
