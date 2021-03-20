package com.nexsoft.buku.service;

import com.nexsoft.buku.model.Grafik;
import com.nexsoft.buku.repository.GrafikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("grafikService")
public class GrafikServiceImpl implements GrafikService{

    @Autowired
    GrafikRepository grafikRepository;

    public List<Grafik> pelangganTeraktif() {
        List<Grafik> pd;
        try{
            pd = grafikRepository.pelangganTeraktif();
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public List<Grafik> pelangganTeraktifFilter(int bulan, int tahun) {
        List<Grafik> pd;
        try{
            pd = grafikRepository.pelangganTeraktifFilter(bulan, tahun);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public List<Grafik> bukuPopuler() {
        List<Grafik> pd;
        try{
            pd = grafikRepository.bukuPopuler();
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public List<Grafik> bukuPopulerFilter(int bulan, int tahun) {
        List<Grafik> pd;
        try{
            pd = grafikRepository.bukuPopulerFilter(bulan, tahun);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public List<Grafik> allPendapatan() {
        List<Grafik> pd;
        try{
            pd = grafikRepository.allPendapatan();
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public List<Grafik> allPendapatanFilter(int bulan, int tahun) {
        List<Grafik> pd;
        try{
            pd = grafikRepository.allPendapatanFilter(bulan, tahun);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public List<Grafik> pengeluaranPelanggan(String idUser) {
        List<Grafik> pd;
        try{
            pd = grafikRepository.pengeluaranPelanggan(idUser);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public List<Grafik> pengeluaranPelangganFilter(String idUser, int bulan, int tahun) {
        List<Grafik> pd;
        try{
            pd = grafikRepository.pengeluaranPelangganFilter(idUser, bulan, tahun);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Grafik totalBukuPinjam(String idUser){
        Grafik pd;
        try{
            pd = grafikRepository.totalBukuPinjam(idUser);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Grafik totalBukuBelumDikembalikan(String idUser){
        Grafik pd;
        try{
            pd = grafikRepository.totalBukuBelumDikembalikan(idUser);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Grafik totalPengeluaran(String idUser){
        Grafik pd;
        try{
            pd = grafikRepository.totalPengeluaran(idUser);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Grafik totalPengeluaranFilter(String idUser, int bulan, int tahun){
        Grafik pd;
        try{
            pd = grafikRepository.totalPengeluaranFilter(idUser, bulan, tahun);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Grafik bukuTerpinjam(){
        Grafik pd;
        try{
            pd = grafikRepository.bukuTerpinjam();
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Grafik totalPendapatanRental(){
        Grafik pd;
        try{
            pd = grafikRepository.totalPendapatanRental();
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Grafik totalPendapatanRentalFilter(int bulan, int tahun){
        Grafik pd;
        try{
            pd = grafikRepository.totalPendapatanRentalFilter(bulan, tahun);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Grafik totalPinjamKomik(String idUser){
        Grafik pd;
        try{
            pd = grafikRepository.totalPinjamKomik(idUser);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Grafik totalPinjamNovel(String idUser){
        Grafik pd;
        try{
            pd = grafikRepository.totalPinjamNovel(idUser);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Grafik totalPinjamEnsiklopedia(String idUser){
        Grafik pd;
        try{
            pd = grafikRepository.totalPinjamEnsiklopedia(idUser);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

}
