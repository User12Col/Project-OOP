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
public class HoaDon {
    Scanner sc= new Scanner(System.in);
    static int dem=1;
    private int stt;
    private String maHD;
    private String tenkh;
    private String diachikh;
    private String ngaylaphd;
    private String nvlaphd;
    private String maSP;
    private String tenSP;
    private int soluong;
    private String giatien;
    public HoaDon()
    {
        stt=dem++;
        maHD=null;
        tenkh=null;
        diachikh=null;
        ngaylaphd=null;
        nvlaphd=null;
        maSP=null;
        tenSP=null;
        soluong=0;
        giatien=null;
    }
    public void nhapHD()
    {
        System.out.println("Nhap ma hoa don: ");
        maHD=sc.nextLine();
        System.out.println("Nhap ten khach hang: ");
        tenkh=sc.nextLine();
        System.out.println("Nhap dia chi khach hang: ");
        diachikh=sc.nextLine();
        System.out.println("Nhap ngay lap hoa don(dd/mm/yyyy): ");
        ngaylaphd=sc.nextLine();
        System.out.println("Nhap ten nhan vien lap hoa don: ");
        nvlaphd=sc.nextLine();
        System.out.println("Nhap ma san pham");
        maSP=sc.nextLine();
        System.out.println("Nhap ten san pham: ");
        tenSP=sc.nextLine();
        System.out.println("Nhap so luong san pham: ");
        soluong=sc.nextInt();
        System.out.println("Nhap gia tien: ");
        giatien=sc.nextLine();
    }

    public String getMaHD() 
    {
        return maHD;
    }

    public void setMaHD(String maHD) 
    {
        this.maHD = maHD;
    }

    public String getTenkh()
    {
        return tenkh;
    }

    public void setTenkh(String tenkh)
    {
        this.tenkh = tenkh;
    }

    public String getDiachikh() 
    {
        return diachikh;
    }

    public void setDiachikh(String diachikh) 
    {
        this.diachikh = diachikh;
    }

    public String getNgaylaphd() 
    {
        return ngaylaphd;
    }

    public void setNgaylaphd(String ngaylaphd) 
    {
        this.ngaylaphd = ngaylaphd;
    }

    public String getMaSP() 
    {
        return maSP;
    }

    public void setMaSP(String maSP) 
    {
        this.maSP = maSP;
    }

    public String getTenSP() 
    {
        return tenSP;
    }

    public void setTenSP(String tenSP) 
    {
        this.tenSP = tenSP;
    }

    public int getSoluong() 
    {
        return soluong;
    }

    public void setSoluong(int soluong) 
    {
        this.soluong = soluong;
    }

    public String getGiatien() 
    {
        return giatien;
    }

    public void setGiatien(String giatien) 
    {
        this.giatien = giatien;
    }
    public void xuatHD()
    {
        System.out.printf("%-5s %-15s %-25s %-36s %-20s %-25s %-15s %-25s %-10s %-20s\n"
            ,stt,maHD,tenkh,diachikh,ngaylaphd,nvlaphd,maSP,tenSP,soluong,giatien);
    }
    public void xuly(String a)
    {
        String []chrt= a.split(";");
        maHD=chrt[0];
        tenkh=chrt[1];
        diachikh=chrt[2];
        ngaylaphd=chrt[3];
        nvlaphd=chrt[4];
        maSP=chrt[5];
        tenSP=chrt[6];
        soluong=Integer.valueOf(chrt[7]);
        giatien=chrt[8];
    }
    public String xylyLuu()
    {
        return maHD+";"+tenkh+";"+diachikh+";"+ngaylaphd+";"+nvlaphd+";"+maSP+";"+tenSP+";"+soluong+";"+giatien+"\n";
    }
    
}
