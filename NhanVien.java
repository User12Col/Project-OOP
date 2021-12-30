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
abstract class LuongChucVu{
    abstract void Luong();
    abstract void ChucVu();
}
public class  NhanVien extends LuongChucVu{
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
        Matcher c;
        do
        {
            System.out.println("Nhap ma nhan vien: ");
            maNV=sc.nextLine();
            String check="^NV[0-9]{2}$";
            Pattern a= Pattern.compile(check);
            c= a.matcher(maNV);
        }
        while(c.find()==false);
        
        do
        {
            System.out.println("Nhap ho ten nhan vien: ");
            hoten=sc.nextLine();
            String check="[^0-9]";
            Pattern a= Pattern.compile(check);
            c= a.matcher(hoten);
        }
        while(c.find()==false);
        
        System.out.println("Nhap dia chi: ");
        diachi=sc.nextLine();
        
        do
        {
            System.out.println("Nhap tuoi: ");
            tuoi=sc.nextLine();
            String check="^[0-9]{2}$";
            Pattern a=Pattern.compile(check);
            c= a.matcher(tuoi);
        }
        while(c.find()==false);
        
        do
        {
            System.out.println("Nhap so dien thoai: ");
            sdt=sc.nextLine();
            String check="^0[0-9]{9}$";
            Pattern b = Pattern.compile(check);
            c= b.matcher(sdt);
        }
        while(c.find()==false);
    }
    public void nhapnv()
    {
        Matcher c;
        do
        {
            System.out.println("Nhap ma nv: ");
            maNV=sc.nextLine();
            String check="^NV[0-9]{2}$";
            Pattern a= Pattern.compile(check);
            c= a.matcher(maNV);
        }
        while(c.find()==false);
        
        do
        {
            System.out.println("Nhap ho ten: ");
            hoten=sc.nextLine();
            String check="[^0-9]";
            Pattern a= Pattern.compile(check);
            c= a.matcher(hoten);
        }
        while(c.find()==false);
        
        System.out.println("Nhap dia chi: ");
        diachi=sc.nextLine();
        
        do
        {
            System.out.println("Nhap tuoi: ");
            tuoi=sc.nextLine();
            String check="^[0-9]{2}$";
            Pattern a=Pattern.compile(check);
            c= a.matcher(tuoi);
        }
        while(c.find()==false);
        
        do
        {
            System.out.println("Nhap so dien thoai: ");
            sdt=sc.nextLine();
            String check="^0[0-9]{9}$";
            Pattern b = Pattern.compile(check);
            c= b.matcher(sdt);
        }
        while(c.find()==false);
        
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

    public static int getDem() 
    {
        return dem;
    }

    public static void setDem(int dem) 
    {
        NhanVien.dem = dem;
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
        chucvu="?????";
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
