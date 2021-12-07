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
public class SanPham {
    Scanner sc=new Scanner(System.in);
    static int dem=1;
    private int stt;
    private String maSP;
    private String tensp;
    private String mota;
    private String baohanh;
    private String nsx;
    private String slhienco;
    public SanPham()
    {
        stt=dem++;
        maSP=null;
        tensp=null;
        mota=null;
        baohanh=null;
        nsx=null;
        slhienco=null;
    }
    public void nhapSP()
    {
        System.out.println("Nhap ma SP: ");
        maSP=sc.nextLine();
        System.out.println("Nhap ten SP: ");
        tensp=sc.nextLine();
        System.out.println("Mo ta san pham(moi, cu, 99%..v...v..): ");
        mota=sc.nextLine();
        System.out.println("Thoi gian bao hanh: ");
        baohanh=sc.nextLine();
        System.out.println("Nhap ten nha san xuat: ");
        nsx=sc.nextLine();
        System.out.println("Nhap so luong hien co: ");
        slhienco=sc.nextLine();
    }

    public static int getDem() 
    {
        return dem;
    }

    public static void setDem(int dem) 
    {
        SanPham.dem = dem;
    }

    public String getMaSP() 
    {
        return maSP;
    }

    public void setMaSP(String maSP) 
    {
        this.maSP = maSP;
    }

    public String getTensp() 
    {
        return tensp;
    }

    public void setTensp(String tensp) 
    {
        this.tensp = tensp;
    }

    public String getMota() 
    {
        return mota;
    }

    public void setMota(String mota) 
    {
        this.mota = mota;
    }

    public String getBaohanh() 
    {
        return baohanh;
    }

    public void setBaohanh(String baohanh) 
    {
        this.baohanh = baohanh;
    }

    public String getNsx() 
    {
        return nsx;
    }

    public void setNsx(String nsx) 
    {
        this.nsx = nsx;
    }

    public String getSlhienco() 
    {
        return slhienco;
    }

    public void setSlhienco(String slhienco) 
    {
        this.slhienco = slhienco;
    }
    public void xuatSP()
    {
        System.out.printf("%-10s %-15s %-25s %-10s %-10s %-15s %-20s\n"
            ,stt,maSP,tensp,mota,baohanh,nsx,slhienco);
    }
    public void xuly(String a)
    {
        String []chrt= a.split(";");
        maSP=chrt[0];
        tensp=chrt[1];
        mota=chrt[2];
        baohanh=chrt[3];
        nsx=chrt[4];
        slhienco=chrt[5];
    }
    public String xylyLuu()
    {
        return maSP+";"+tensp+";"+mota+";"+baohanh+";"+nsx+";"+slhienco+"\n";
    }
}
