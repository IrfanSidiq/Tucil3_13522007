# Tugas Kecil 3 IF2211 Strategi Algoritma

> Menentukan Rute Terpendek antara suatu kata menuju kata lain dengan algoritma UCS, Greedy BFS, dan A*

## Table of Contents

- [General Info](#general-information)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Setup](#setup)
- [Usage](#usage)
- [Project Status](#project-status)
- [Room for Improvement](#room-for-improvement)
- [Acknowledgements](#acknowledgements)
- [Creator](#creator)

## General Information

Word ladder (juga dikenal sebagai Doublets, word-links, change-the-word puzzles, paragrams, laddergrams, atau word golf) adalah salah satu permainan kata yang terkenal bagi seluruh kalangan. Pada permainan ini, pemain diberikan dua kata yang disebut sebagai start word dan end word. Untuk memenangkan permainan, pemain harus menemukan rantai kata yang dapat menghubungkan antara start word dan end word. Banyaknya huruf pada start word dan end word selalu sama. Tiap kata yang berdekatan dalam rantai kata tersebut hanya boleh berbeda satu huruf saja. Pada permainan ini, diharapkan solusi optimal, yaitu solusi yang meminimalkan banyaknya kata yang dimasukkan pada rantai kata. Berikut adalah ilustrasi serta aturan permainan.


Pada Tugas Kecil 3 ini, penulis merancang program untuk menerapkan algoritma UCS, Greedy Best-First Search, dan A* yang telah dipelajari di kelas untuk mencari rute terpendek antara suatu kata menuju kata lain pada kamus dengan mengubah maksimal satu huruf per langkah. Program menyediakan opsi untuk memilih menggunakan salah satu dari ketiga algoritma diatas, kemudian menampilkan solusi rute yang diitemukan (jika ada) serta menampilkan jumlah langkah, jumlah simpul yang dikunjungi, dan waktu eksekusi algoritma. Program kecil ini dibuat menggunakan bahasa Java dan dijalankan melalui CLI, serta menerima input berupa: 1) kata awal (start word) dan kata akhir (end word), serta 2) pilihan algoritma yang ingin digunakan.


## Technologies Used

- Java - version 20.0.2

## Features

- Mencari rute terpendek antara dua kata menggunakan algoritma Uniform Cost Search
- Mencari rute terpendek antara dua kata menggunakan algoritma Greedy Best-First Search
- Mencari rute terpendek antara dua kata menggunakan algoritma A*
- Menampilkan GUI untuk menjalankan program

## Setup

1. Clone repository ini dengan perintah `git clone https://github.com/IrfanSidiq/Tucil3_13522007.git`

## Usage

1. Pindah current folder ke working repository (Tucil3_13522007)
2. Jalankan perintah `make build`
3. Jalankan perintah `make run` untuk menjalankan program di CLI, atau `make gui` untuk menjalankan program di GUI

## Project Status

Project is: _complete_

## Room for Improvement

Pengembangan kedepannya dapat dilakukan dengan menambahkan fitur berikut:

- Mempercantik tampilan GUI
- Menampilkan simulasi pencarian kata pada GUI

## Acknowledgements

Ucapan terima kasih diberikan kepada:
- Pak Rinaldi Munir selaku dosen mata kuliah IF2211 yang telah mengajarkan materi divide and conquer
- Tim Asisten yang telah membimbing untuk membuat tugas kecil 3 ini

## Creator

| NIM      | Nama                |
| -------- | ------------------- |
| 13522007 | Irfan Sidiq Permana |