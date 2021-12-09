/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author HP ADMIN
 */
public class DSNhanVien {
    Scanner sc=new Scanner(System.in);
    private int n;
    private NhanVien []dsnv;
    public DSNhanVien()
    {
        n=0;
        dsnv=null;
    }
    public void docDSNV() 
    {
        try 
        {
            FileInputStream file= new FileInputStream("D:/ChuongTrinh/InputDSNV.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line=null;
            int dem=0;
            try 
            {
                n=demNV();
                dsnv=new NhanVien[n];
                int i=0;
                while((line = buffer.readLine())!=null)
                {
                    dsnv[i]=new NhanVien();
                    dsnv[i].xuly(line);
                    i++;
                }
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int demNV()
    {
        int dem=0;
        try 
        {
            FileInputStream file= new FileInputStream("D:/ChuongTrinh/InputDSNV.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line=null;
            try 
            {
                while((line = buffer.readLine())!=null)
                {
                    dem++;
                }
                n=dem;
                
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
    public void capNhatDSNV()
    {
        FileOutputStream fos=null;
        try 
        {
            fos = new FileOutputStream("D:/ChuongTrinh/InputDSNV.txt");
            for(int i=0;i<n;i++)
            {
                String line = dsnv[i].xylyLuu();
                try 
                {
                    byte []infor= line.getBytes("utf8");
                    try 
                    {
                        fos.write(infor);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                catch (UnsupportedEncodingException ex) 
                {
                    Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Cap nhat du lieu thanh cong !!!");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(fos != null)
            {
                try 
                {
                    fos.close();
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void themNV(NhanVien nv)
    {
        dsnv=Arrays.copyOf(dsnv, n+1);
        for(int i=0;i<n+1;i++)
        {
            if(i==n)
            {
                dsnv[i]=nv;
            }
        }
        n++;
        capNhatDSNV();
    }
    public void xoaNV()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma nhan vien can xoa: ");
            a=sc.nextLine();
            String check="^NV[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key= dsnv[i].getMaNV();
            if( key.contentEquals(a)== true)
            {
                for(int j=i;j<n-1;j++)
                {
                    dsnv[j]=dsnv[j+1];
                }
                n--;
                dsnv=Arrays.copyOf(dsnv, n);
            }
        }
        capNhatDSNV();
    }
    public void suaNV()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma nhan vien can sua: ");
            a=sc.nextLine();
            String check="^NV[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key= dsnv[i].getMaNV();
            if(key.contentEquals(a)==true)
            {
                System.out.println("Nhap thong tin nhan vien");
                NhanVien nv= new NhanVien();
                nv.nhapnv();
                dsnv[i]=nv;
            }
        }
        capNhatDSNV();
    }
    public void timkiemNV()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma nhan vien can tim: ");
            a=sc.nextLine();
            String check="^NV[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            System.out.println("================================================");
            System.out.printf("%-10s %-10s %-20s %-30s %-15s %-10s %-15s %-20s\n"
                ,"STT","Ma NV","Ho Ten","Dia Chi","So dien thoai","Tuoi","Chuc vu","Luong");
            String key= dsnv[i].getMaNV();
            if(key.contentEquals(a)==true)
            {
                dsnv[i].xuatNV();
                break;
            }
        }
    }
    public void xuatDSNV()
    {
        System.out.printf("%-10s %-10s %-20s %-30s %-15s %-10s %-15s %-20s\n"
            ,"STT","Ma NV","Ho Ten","Dia Chi","So dien thoai","Tuoi","Chuc vu","Luong");
        for(int i=0;i<n;i++)
        {
            dsnv[i].xuatNV();
        }
    }
    
    
    
}
