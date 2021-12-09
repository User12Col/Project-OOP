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
public class SanPham {
    Scanner sc=new Scanner(System.in);
    static int dem=0;
    private int stt=1;
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
        
        Matcher c;
        do{
            System.out.println("Nhap ma san pham: ");
            maSP=sc.nextLine();
            String check="^SP[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(maSP);
        }
        while(c.find()==false);
        
        System.out.println("Nhap ten san pham: ");
        tensp=sc.nextLine();
        
        System.out.println("Mo ta san pham(moi, cu, 99%..v...v..): ");
        mota=sc.nextLine();
        
        
        do{
            System.out.println("Thoi gian bao hanh: ");
            baohanh=sc.nextLine();
            String check="[0-9]+\\s+years";
            Pattern b = Pattern.compile(check);
            c = b.matcher(baohanh);
        }
        while(c.find()==false);
        
        System.out.println("Nhap ten nha san xuat: ");
        nsx=sc.nextLine();
        
        do{
            System.out.println("Nhap so luong hien co: ");
            slhienco=sc.nextLine();
            String check="[0-9]";
            Pattern b = Pattern.compile(check);
            c = b.matcher(slhienco);
        }
        while(c.find()==false);
        
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

    public int getStt() 
    {
        return stt;
    }

    public void setStt(int stt) 
    {
        this.stt = stt;
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
