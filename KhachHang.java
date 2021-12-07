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
        System.out.println("Nhap ma nv: ");
        maKH=sc.nextLine();
        System.out.println("Nhap ho ten: ");
        hoten=sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        sdt=sc.nextLine();
        System.out.println("Nhap dia chi: ");
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
