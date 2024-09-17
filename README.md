# **1. CRUD** 
CRUD adalah istilah yang merujuk pada empat kegiatan dasar dalam mengelola informasi :  
- Create berarti menambahkan informasi baru
- Read berarti melihat atau mengambil informasi yang sudah ada
- Update berarti mengubah informasi yang sudah ada
- Delete berarti menghilangkan informasi dari sistem. 

  
# **2. EXCEPTION**
## **Pengertian Exception**
Exception adalah istilah dalam pemrograman yang menggambarkan situasi tak terduga yang muncul saat program dijalankan. Ketika exception terjadi, program tidak dapat melanjutkan prosesnya secara normal dan perlu ada penanganan khusus untuk mengatasi masalah tersebut.

## **A. Pengertian Try Catch**
Try catch adalah mekanisme yang digunakan untuk menangani exception, yaitu situasi tidak terduga yang dapat muncul selama eksekusi program. Dengan menggunakan blok try dan catch, kita dapat mengisolasi bagian kode yang mungkin menyebabkan kesalahan dan menyediakan cara untuk mengatasi kesalahan tersebut agar program tetap dapat berjalan.
### **Struktur Dasar Try Catch**
- Try Block : Bagian ini berisi kode yang berpotensi menghasilkan exception. 
- Catch Block : Bagian ini menangkap exception yang terjadi dalam blok try.
## Source Code Try Catch
<pre>
  public static void main(String[] args) {
        CobaException belajar = new CobaException();

        // Menggunakan try-catch untuk menangani ArithmeticException
        try {
            int hasil1 = belajar.bagiBilangan(10, 0); 
            System.out.println("Hasil: " + hasil1);
        } catch (ArithmeticException e) {
            System.out.println("Error: Pembagian dengan nol tidak diperbolehkan.");
        }
    }
</pre>
Dalam kode ini, kita membuat objek dari kelas CobaException dan menggunakan blok try-catch untuk menangani kemungkinan terjadinya ArithmeticException. Di dalam blok try, kita mencoba membagi angka 10 dengan 0, yang akan memicu pengecualian. Jika terjadi ArithmeticException, blok catch akan menangkapnya dan mencetak pesan bahwa pembagian dengan nol tidak diperbolehkan.

## **B. Throws**
Throw adalah istilah untuk menggambarkan tindakan mengeluarkan sebuah kesalahan (exception) secara manual dalam pemrograman. Dengan menggunakan throw, dapat memicu kesalahan ketika kondisi tertentu terpenuhi, sehingga memungkinkan penanganan masalah dengan cara yang lebih tepat.

## Source Code Throws
<pre>
   public int bagiBilangan(int a, int b) throws ArithmeticException {
        return a / b; // Potensi ArithmeticException
    }
</pre>
Pada metode ini tidak ada penanganannya karena hanya menggunakan metode throws yang artinya kesalahan hanya di lempar saja tanpa di tangani. Meski kita tidak menangkapnya di sini, metode ini menyatakan bahwa bisa terjadi ArithmeticException.

## **C. Custom Exception**
Custom exception adalah jenis exception yang dibuat untuk memenuhi kebutuhan khusus dalam sebuah aplikasi. Dengan menggunakan custom exception, kita dapat menangani kesalahan dengan cara yang lebih sesuai dan memberikan informasi yang lebih jelas tentang masalah yang muncul.

## Source Code Custom 
<pre>
  public class LauraException extends Exception {
    public LauraException(String s){
        super(s);
    }
}
</pre>
Dalam kode ini kita buat kelas baru bernama LauraException yang merupakan turunan dari kelas Exception. Ini berarti LauraException adalah jenis kesalahan (exception) yang dapat kita buat sendiri. Kelas ini memiliki konstruktor yang menerima satu parameter bertipe String. Parameter ini digunakan untuk menyimpan pesan kesalahan yang akan ditampilkan saat exception ini terjadi. Kata kunci super(s) memanggil konstruktor dari kelas Exception untuk mengatur pesan kesalahan.

Main Class :
<pre>
  public class Utama {
    public static void main(String[] args)  {
        try {
            throw new LauraException("Coba duls");
        } catch (LauraException ex) {
            System.out.println("Ditangkap : " +String.valueOf(ex));
        }
    }
}
</pre>
Buat metode main untuk mengeksekusi program, dimana dalam blok try, kita "melempar" atau throw sebuah objek LauraException dengan pesan "Coba duls". Ini menyebabkan exception terjadi. Setelah program dilempar, maka akan di tangkap oleh blok catch dan diikuti dengan informasi tentang exception yang ditangkap.
