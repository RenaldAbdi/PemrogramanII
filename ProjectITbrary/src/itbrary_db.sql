-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Des 2022 pada 15.29
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `itbrary_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `nobuku` int(11) NOT NULL,
  `judul` varchar(250) NOT NULL,
  `pengarang` varchar(250) NOT NULL,
  `tahun` varchar(250) NOT NULL,
  `penerbit` varchar(250) NOT NULL,
  `id_buku` varchar(250) NOT NULL,
  `stok` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`nobuku`, `judul`, `pengarang`, `tahun`, `penerbit`, `id_buku`, `stok`) VALUES
(23, 'Fitoremediasi : alternatif pengelolaan limbah dengan sistem lahan basah', 'Eko Rini Indrayatie', '2018', 'CV. IRDH ', '101', '20'),
(24, 'Buku ajar pemrograman Web kerja cerdas membangun Web Service, UI/UX dan web Multimedia', 'Sopingi – Mei Purweni', '2018', 'CV Pustaka Bengawan', '102', '10'),
(25, 'Layout 2020 : mengenal layout cetak, UI/UX, website & apps', 'Rustan', '2020', 'CV. Nulisbuku Jendela Dunia', '103', '10'),
(26, 'Konsep pemrograman dengan bahasa C', 'Eka Mistiko Rini, Devit Suwardiyanto, Muh. Fuad Al Haris', '2016', 'Absolute Media', '104', '10'),
(27, 'Software engeneering dalam pemrograman Java', 'Eva Darnila, Wahyu Fuadi', '2017', 'Sefa Bumi Persada', '105', '10'),
(28, 'Algoritma dan struktur data', 'Abidatul Izzah & Selvia Ferdiana', '2017', 'Adjie Media Nusantara', '106', '10'),
(29, 'Membuat aplikasi internet berbasis database SQL server dengan pemrograman ASP', 'Rony Setiawan', '2012', 'Lentera Ilmu Cendekia', '107', '10'),
(30, 'Matematika diskrit : teori dan aplikasi', 'Rika Yunitarini', '2022', 'CV. Literasi Nusantara Abadi', '108', '10'),
(31, 'Pengantar statistika', 'Arnita', '2019', 'Perdana Mulya Sarana', '109', '10'),
(32, 'Interaksi manusia komputer', 'Rr. Yuliana Rachmawati K', '2012', 'Akprind Press', '110', '11'),
(33, 'Kamus lengkap idiom Inggris-Indonesia', 'Suwardi Salim', '2015', 'Gama Press', '201', '10'),
(34, 'Kamus lengkap Inggris-Indonesia Indonesia -Inggris', 'Suwardi Salim', '2015', 'Gama Press', '202', '10'),
(35, 'Kamus teknologi informasi komunikasi', 'Utami Handayani ; editor, Kuncoro', '2014', 'CV. Mitra Edukasi Indonesia', '203', '10'),
(36, 'Kamus teknologi informasi dan komunikasi bergambar', 'Dzik Rona Suhan, Ichsan Suhada ; editor, I. Suhada', '2017', 'Acarya Media Utama', '204', '10'),
(37, 'King dictionary kamus Inggris terlengkap', 'Salemba Language Center', '2020', 'Penerbit EMC (Edukasi Media Cemerlang)', '205', '10'),
(38, 'Smart dictionary kamus Inggris terlengkap : Inggris - Indonesia Indonesia Indonesia - Inggris', 'Zurich Education Team', '2019', 'CV Oxygen Media Ilmu', '206', '10'),
(39, 'Kamus komputer', 'Mei Lestari, Rosdiana', '2014', 'Mitra Abadi Edukatama', '207', '10'),
(40, 'Kamus istilah listrik dan elektronika', 'Aulia Rahmat Suatmaji ; penyunting, Ari', '2015', 'CV. Istana Media', '208', '10'),
(41, 'Kamus lengkap EYD', 'M. Miftah Fauzi', '2014', 'Human Books', '209', '10'),
(42, 'Kamus praktis Inggris-Indonesia Indonesia-Inggris : untuk pelajar, mahasiswa, dan umum', 'Tim Pusat Kajian Bahasa Asing; penyunting, Mustika Putri', '2019', 'Anak Hebat Indonesia', '210', '10'),
(43, 'Malaikat bertanduk : kumpulan cerpen', 'Muhammad Akis ; editor, Muhammad Arief', '2014', 'Absolute Media', '301', '10'),
(44, 'Mantra cemara : antologi cerpen', 'Dzakwan Ali, dkk', '2015', 'Gong Publishing', '302', '10'),
(45, 'Mata empat : kumpulan cerpen', 'Riki Utomi', '2013', 'Ladang Publishing', '303', '10'),
(46, 'Catatan dari lereng Merapi : kumpulan cerpen', 'Gunarti Afha Mujahidah', '2013', 'Indie Publishing', '304', '10'),
(47, 'Taman pelangi : sebuah kumpulan cerpen', 'Dani Ardiansyah', '2018', 'Indie Publishing', '305', '10'),
(48, 'Kerinduan tak berujung : antologi cerpen', 'Anno D. Sanjari', '2019', 'CV Eksismedia Grafisindo', '306', '10'),
(49, 'Bidadari benua : antologi cerpen FLP Sumsel', 'Azzura Dayana', '2013', 'FLP Sumatera Selatan', '307', '10'),
(50, 'Ilalang kering di Bukit Lendongara : kumpulan cerpen hikmah', 'Eri Hariyanto', '2021', 'CV. Primaprint', '308', '10'),
(51, 'Bisikan hujan : kumpulan cerpen', 'Dita Ayu Maharani, Zuhrisnaini Adaminata', '2014', 'Sembilan Mutiara Publishing', '309', '10'),
(52, 'Mozaik Putih Abu-abu : Kupulan Cerpen', 'Ade Liani Ferli, Amelia Susanti', '2014', 'Sembilan Mutiara Publishing', '310', '10'),
(53, 'Komik sains global warming', 'Anip Dwi Saputro', '2021', 'Universitas Muhammadiyah Ponorogo Press', '401', '10'),
(54, 'Si nopal komik strip', 'Naufal Faridurrazak ', '2018', 'PT. Bukune Kreatif Cipta', '402', '10'),
(55, 'Si Juki pandemik : panjat dengan komik', 'Pionicon', '2020', 'PT. Bukune Kreatif Cipta', '403', '10'),
(56, 'Sang patriot : komik perjuangan mempertahankan kemerdekaan Indonesia', 'Irma Devita', '2015', 'Inti Dinamika Publishers', '404', '10'),
(57, 'Komik Dilan', 'Pidi Baiq', '2020', 'The Panasdalam Publishing', '405', '10'),
(58, 'Cantik Itu Luka', 'Eka Kurniawan', '2018', 'Gramedia Pustaka Utama', '501', '10'),
(59, 'Bibi Gill', 'Tere Liye', '2022', 'Penerbit Sabak Grip', '502', '10'),
(60, 'Layangan Putus', 'Mommy ASF', '2010', 'Rdm Publishers', '503', '10'),
(61, 'Hujan', 'Tere Liye', '2022', 'Penerbit Sabak Grip', '504', '10'),
(62, 'Laut Bercerita', 'Leila S. Chudori', '2017', 'Kepustakaan Populer Gramedia', '505', '10'),
(63, 'Bumi', 'Tere Liye', '2014', 'Gramedia Pustaka Utama', '506', '10'),
(64, 'Bumi Manusia', 'Pramoedya Ananta Toer', '1980', 'Hasta Mitra', '507', '10'),
(65, 'Laskar Pelangi', 'Andrea Hirata', '2005', 'Bentang Pustaka', '508', '10'),
(66, 'Kata', 'Nadhifa Allya Tsana', '2018', 'Gagas Media', '509', '10'),
(67, 'Geez & Ann #1', 'Nadhifa Allya Tsana', '2017', 'Gagas Media', '510', '10');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE `peminjaman` (
  `nopeminjaman` int(11) NOT NULL,
  `id_buku` varchar(250) NOT NULL,
  `nim` varchar(250) NOT NULL,
  `judul` varchar(250) NOT NULL,
  `namamahasiswa` varchar(250) NOT NULL,
  `tanggalpeminjaman` date NOT NULL,
  `tanggalpengembalian` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`nopeminjaman`, `id_buku`, `nim`, `judul`, `namamahasiswa`, `tanggalpeminjaman`, `tanggalpengembalian`) VALUES
(2, '503', '2110817210005', 'Satwa Terancam Bahaya', 'M. Renald Abdi', '2022-12-23', '2022-12-30'),
(3, '503', '2110817210005', 'Satwa Terancam Bahaya', 'M. Renald Abdi', '2022-12-31', '2023-01-07'),
(4, '103', '2110817220003', 'Layout 2020 : mengenal layout cetak, UI/UX, website & apps', 'Salsa Maulidina Puteri', '2022-11-08', '2022-11-15'),
(5, '301', '2110817220003', 'Malaikat bertanduk : kumpulan cerpen', 'Salsa Maulidina Puteri', '2022-11-01', '2022-11-08'),
(6, '504', '2110817120011', 'Hujan', 'Siti Rahmah', '2022-12-08', '2022-12-15'),
(7, '109', '2110817220021', 'Pengantar statistika', 'Anya Fidela S R', '2022-12-12', '2022-12-19'),
(8, '205', '2110817220021', 'King dictionary kamus Inggris terlengkap', 'Anya Fidela S R', '2022-11-08', '2022-11-15'),
(9, '508', '2110817220011', 'Laskar Pelangi', 'Ana Nestania', '2022-12-26', '2023-01-02'),
(10, '507', '2110817220011', 'Bumi Manusia', 'Ana Nestania', '2022-12-25', '2023-01-01'),
(11, '302', '2110817120011', 'Mantra cemara : antologi cerpen', 'Siti Rahmah', '2022-12-01', '2022-12-08'),
(12, '110', '2110817120011', 'Interaksi manusia komputer', 'Siti Rahmah', '2022-12-10', '2022-12-17'),
(13, '504', '2110817210005', 'Hujan', 'M. Renald Abdi', '2022-12-26', '2023-01-02');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengembalian`
--

CREATE TABLE `pengembalian` (
  `nopengembalian` int(11) NOT NULL,
  `id_buku` varchar(250) NOT NULL,
  `nim` varchar(250) NOT NULL,
  `judul` varchar(250) NOT NULL,
  `namamahasiswa` varchar(250) NOT NULL,
  `tanggalpeminjaman` date NOT NULL,
  `tanggalpengembalian` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pengembalian`
--

INSERT INTO `pengembalian` (`nopengembalian`, `id_buku`, `nim`, `judul`, `namamahasiswa`, `tanggalpeminjaman`, `tanggalpengembalian`) VALUES
(1, '503', '2110817210005', 'Satwa Terancam Bahaya', 'M. Renald Abdi', '2022-12-23', '2022-12-30'),
(2, '503', '2110817210005', 'Satwa Terancam Bahaya', 'M. Renald Abdi', '2022-12-31', '2023-01-07'),
(3, '103', '2110817220003', 'Layout 2020 : mengenal layout cetak, UI/UX, website & apps', 'Salsa Maulidina Puteri', '2022-11-08', '2022-11-15'),
(4, '301', '2110817220003', 'Malaikat bertanduk : kumpulan cerpen', 'Salsa Maulidina Puteri', '2022-11-01', '2022-11-08'),
(5, '504', '2110817120011', 'Hujan', 'Siti Rahmah', '2022-12-08', '2022-12-15'),
(6, '109', '2110817220021', 'Pengantar statistika', 'Anya Fidela S R', '2022-12-12', '2022-12-19'),
(7, '205', '2110817220021', 'King dictionary kamus Inggris terlengkap', 'Anya Fidela S R', '2022-11-08', '2022-11-15'),
(8, '508', '2110817220011', 'Laskar Pelangi', 'Ana Nestania', '2022-12-26', '2023-01-02'),
(9, '507', '2110817220011', 'Bumi Manusia', 'Ana Nestania', '2022-12-25', '2023-01-01'),
(10, '302', '2110817120011', 'Mantra cemara : antologi cerpen', 'Siti Rahmah', '2022-12-01', '2022-12-08'),
(11, '110', '2110817120011', 'Interaksi manusia komputer', 'Siti Rahmah', '2022-12-10', '2022-12-18'),
(12, '110', '2110817120011', 'Interaksi manusia komputer', 'Siti Rahmah', '2022-12-10', '2022-12-17'),
(13, '504', '2110817210005', 'Hujan', 'M. Renald Abdi', '2022-12-26', '2023-01-02');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`nobuku`);

--
-- Indeks untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`nopeminjaman`);

--
-- Indeks untuk tabel `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`nopengembalian`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `buku`
--
ALTER TABLE `buku`
  MODIFY `nobuku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `nopeminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT untuk tabel `pengembalian`
--
ALTER TABLE `pengembalian`
  MODIFY `nopengembalian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
