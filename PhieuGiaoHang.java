/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

import java.util.Scanner;

/**
 *
 * @author HP ADMIN
 */
public class PhieuGiaoHang {
    Scanner sc=new Scanner(System.in);
    static int dem=1;
    private int stt;
    private String maPGH;
    private String maHD;
    private String tinhtrang;
    private String ngaybd;
    private String ngaykt;
    public PhieuGiaoHang()
    {
        stt=dem++;
        maPGH=null;
        maHD=null;
        tinhtrang=null;
        ngaybd=null;
        ngaykt=null;
    }

    public String getMaPGH() 
    {
        return maPGH;
    }

    public void setMaPGH(String maPGH) 
    {
        this.maPGH = maPGH;
    }

    public String getMaHD() 
    {
        return maHD;
    }

    public void setMaHD(String maHD) 
    {
        this.maHD = maHD;
    }

    public String getTinhtrang() 
    {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) 
    {
        this.tinhtrang = tinhtrang;
    }

    public String getNgaybd() 
    {
        return ngaybd;
    }

    public void setNgaybd(String ngaybd) 
    {
        this.ngaybd = ngaybd;
    }

    public String getNgaykt() 
    {
        return ngaykt;
    }

    public void setNgaykt(String ngaykt) 
    {
        this.ngaykt = ngaykt;
    }
    public void nhapPGH()
    {
        System.out.println("Nhap ma phieu giao hang: ");
        maPGH=sc.nextLine();
        System.out.println("Nhap ma hoa don: ");
        maHD=sc.nextLine();
        System.out.println("Nhap trang thai giao hang: ");
        tinhtrang=sc.nextLine();
        System.out.println("Nhap ngay bat dau giao: ");
        ngaybd=sc.nextLine();
        System.out.println("Nhap ngay giao thanh cong(Nhap null neu don hang giao chua xong): ");
        ngaykt=sc.nextLine();
    }
    public void xuatPGH()
    {
        System.out.printf("%-5s %-20s %-15s %-25s %-15s %-15s\n"
                ,stt,maPGH,maHD,tinhtrang,ngaybd,ngaykt);
    }
    public void xuly(String a)
    {
        String []chrt= a.split(";");
        maPGH=chrt[0];
        maHD=chrt[1];
        tinhtrang=chrt[2];
        ngaybd=chrt[3];
        ngaykt=chrt[4];
    }
    public String xylyLuu()
    {
        return maPGH+";"+maHD+";"+tinhtrang+";"+ngaybd+";"+ngaykt+"\n";
    }
}
