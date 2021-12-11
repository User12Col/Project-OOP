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
public class KhachHang {
    Scanner sc=new Scanner(System.in);
    static int dem=1;
    private int stt;
    private String maKH;
    private String hoten;
    private String diachi;
    private String sdt;
    public KhachHang()
    {
        stt=dem++;
        hoten=null;
        diachi=null;
        sdt=null;
        maKH=null;
    }
    public void nhapKH()
    {
        Matcher c;
        do
        {
            System.out.println("Nhap ma khach hang: ");
            maKH=sc.nextLine();
            String check="^KH[0-9]{2}$";
            Pattern a= Pattern.compile(check);
            c= a.matcher(maKH);
        }
        while(c.find()==false);
        
        do
        {
            System.out.println("Nhap ho ten khach hang: ");
            hoten=sc.nextLine();
            String check="[^0-9]";
            Pattern a= Pattern.compile(check);
            c= a.matcher(hoten);
        }
        while(c.find()==false);
        
        do
        {
            System.out.println("Nhap so dien thoai khach hang: ");
            sdt=sc.nextLine();
            String check="^0[0-9]{9}$";
            Pattern b = Pattern.compile(check);
            c= b.matcher(sdt);
        }
        while(c.find()==false);
        
        System.out.println("Nhap dia chi khach hang: ");
        diachi=sc.nextLine();
    }

    public String getMaKH() 
    {
        return maKH;
    }

    public void setMaKH(String maKH) 
    {
        this.maKH = maKH;
    }

    public static int getDem() 
    {
        return dem;
    }

    public static void setDem(int dem) 
    {
        KhachHang.dem = dem;
    }
    
    public String getHoten() 
    {
        return hoten;
    }

    public void setHoten(String hoten) 
    {
        this.hoten = hoten;
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
    public void xuatKH()
    {
        System.out.printf("%-10s %-10s %-25s %-40s %-15s\n"
            ,stt,maKH,hoten,diachi,sdt);
    }
    public void xuly(String a)
    {
        String []chrt= a.split(";");
        maKH=chrt[0];
        hoten=chrt[1];
        sdt=chrt[2];
        diachi=chrt[3];
    }
    public String xylyLuu()
    {
        return maKH+";"+hoten+";"+sdt+";"+diachi+"\n";
    }
}
