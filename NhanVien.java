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
public class NhanVien {
    Scanner sc=new Scanner(System.in);
    private int stt;
    static int dem=1;
    private String maNV;
    private String hoten;
    private String diachi;
    private String tuoi;
    private String sdt;
    protected String chucvu;
    protected String luong;
    public NhanVien()
    {
        maNV=null;
        hoten=null;
        diachi=null;
        tuoi=null;
        sdt=null;
        chucvu=null;
        luong=null;
        stt=dem++;
    }
    public void nhapNV()
    {
        System.out.println("Nhap ma nv: ");
        maNV=sc.nextLine();
        System.out.println("Nhap ho ten: ");
        hoten=sc.nextLine();
        System.out.println("Nhap dia chi: ");
        diachi=sc.nextLine();
        System.out.println("Nhap tuoi: ");
        tuoi=sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        sdt=sc.nextLine();
    }
    public void nhapnv()
    {
        System.out.println("Nhap ma nv: ");
        maNV=sc.nextLine();
        System.out.println("Nhap ho ten: ");
        hoten=sc.nextLine();
        System.out.println("Nhap dia chi: ");
        diachi=sc.nextLine();
        System.out.println("Nhap tuoi: ");
        tuoi=sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        sdt=sc.nextLine();
        System.out.println("Nhap chuc vu: ");
        chucvu=sc.nextLine();
        System.out.println("Nhap muc luong: ");
        luong=sc.nextLine();
    }
    public String getMaNV() 
    {
        return maNV;
    }

    public void setMaNV(String maNV) 
    {
        this.maNV = maNV;
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

    public String getTuoi() 
    {
        return tuoi;
    }

    public void setTuoi(String tuoi) 
    {
        this.tuoi = tuoi;
    }

    public String getSdt() 
    {
        return sdt;
    }

    public void setSdt(String sdt) 
    {
        this.sdt = sdt;
    }

    public String getChucvu() 
    {
        return chucvu;
    }

    public void setChucvu(String chucvu) 
    {
        this.chucvu = chucvu;
    }

    public String getLuong() 
    {
        return luong;
    }

    public void setLuong(String luong) 
    {
        this.luong = luong;
    }
    
    public void ChucVu()
    {
        chucvu="????";
    }
    public void Luong()
    {
        luong="????";
    }
    public void xuatNV()
    {
        System.out.printf("%-10s %-10s %-20s %-30s %-15s %-10s %-15s %-20s\n"
            ,stt,maNV,hoten,diachi,sdt,tuoi,chucvu,luong);
    }
    public void xuly(String a)
    {
        String []chrt= a.split(";");
        maNV=chrt[0];
        hoten=chrt[1];
        diachi=chrt[2];
        sdt=chrt[3];
        tuoi=chrt[4];
        chucvu=chrt[5];
        luong=chrt[6];
    }
    public String xylyLuu()
    {
        return maNV+";"+hoten+";"+diachi+";"+sdt+";"+tuoi+";"+chucvu+";"+luong+"\n";
    }
    
    
}
