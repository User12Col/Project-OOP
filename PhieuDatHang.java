/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HP ADMIN
 */
public class PhieuDatHang {
    Scanner sc=new Scanner(System.in);
    static int dem=1;
    private int stt;
    private String maPDH;
    private String tenKH;
    private String diachi;
    private String sdt;
    private String maSP;
    private String soluong;
    private String ngaydh;
    public PhieuDatHang()
    {
        stt=dem++;
        maPDH=null;
        tenKH=null;
        diachi=null;
        sdt=null;
        maSP=null;
        soluong=null;
        ngaydh=null;
    }

    public String getMaPDH() 
    {
        return maPDH;
    }

    public void setMaPDH(String maPDH) 
    {
        this.maPDH = maPDH;
    }

    public String getTenKH() 
    {
        return tenKH;
    }

    public void setTenKH(String tenKH) 
    {
        this.tenKH = tenKH;
    }

    public String getDiachi() 
    {
        return diachi;
    }

    public void setDiachi(String diachi) 
    {
        this.diachi = diachi;
    }

    public String getSdt() 
    {
        return sdt;
    }

    public void setSdt(String sdt) 
    {
        this.sdt = sdt;
    }

    public String getMaSP() 
    {
        return maSP;
    }

    public void setMaSP(String maSP) 
    {
        this.maSP = maSP;
    }

    public String getSoluong() 
    {
        return soluong;
    }

    public void setSoluong(String soluong) 
    {
        this.soluong = soluong;
    }

    public String getNgaydh() 
    {
        return ngaydh;
    }

    public void setNgaydh(String ngaydh) 
    {
        this.ngaydh = ngaydh;
    }
    public void nhapPDH()
    {
        Matcher c;
        do
        {
            System.out.println("Nhap ma phieu dat hang: ");
            maPDH=sc.nextLine();
            String check="^PDH[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(maPDH);
        }
        while(c.find()==false);
        
        do
        {
            System.out.println("Nhap ten khach hang: ");
            tenKH=sc.nextLine();
            String check="[^0-9]";
            Pattern b=Pattern.compile(check);
            c=b.matcher(tenKH);
        }
        while(c.find()==false);
        
        System.out.println("Nhap dia chi cua khach hang: ");
        diachi=sc.nextLine();
        
        do
        {
            System.out.println("Nhap so dien thoai: ");
            sdt=sc.nextLine();
            String check="^0[0-9]{9}$";
            Pattern b = Pattern.compile(check);
            c= b.matcher(sdt);
        }
        while(c.find()==false);
        
        do{
            System.out.println("Nhap ma san pham: ");
            maSP=sc.nextLine();
            String check="^SP[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(maSP);
        }
        while(c.find()==false);
        
        do{
            System.out.println("Nhap so luong dat: ");
            soluong=sc.nextLine();
            String check="[0-9]";
            Pattern b = Pattern.compile(check);
            c = b.matcher(soluong);
        }
        while(c.find()==false);
        
        do
        {
            System.out.println("Nhap ngay lap phieu: ");
            ngaydh=sc.nextLine();
            String check="^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
            Pattern b= Pattern.compile(check);
            c=b.matcher(ngaydh);
        }
        while(c.find()==false);
        
    }
    public void xuatPDH()
    {
        System.out.printf("%-5s %-25s %-25s %-36s %-20s %-15s %-10s %-15s\n"
        ,stt,maPDH,tenKH,diachi,sdt,maSP,soluong,ngaydh);
    }
    public void xuly(String a)
    {
        String []chrt=a.split(";");
        maPDH=chrt[0];
        tenKH=chrt[1];
        diachi=chrt[2];
        sdt=chrt[3];
        maSP=chrt[4];
        soluong=chrt[5];
        ngaydh=chrt[6];
    }
    public String xulyLuu()
    {
        return maPDH+";"+tenKH+";"+diachi+";"+sdt+";"+maSP+";"+soluong+";"+ngaydh+"\n";
    }
    
}
