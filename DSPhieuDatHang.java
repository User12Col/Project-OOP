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
public class DSPhieuDatHang {
    Scanner sc=new Scanner(System.in);
    private int n;
    private PhieuDatHang []dspdh;
    public DSPhieuDatHang()
    {
        n=0;
        dspdh=null;
    }
    public int demPDH()
    {
        int dem=0;
        try 
        {
            FileInputStream file = new FileInputStream("D:/ChuongTrinh/InputDSPDH.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line=null;
            try 
            {
                
                while ((line = buffer.readLine())!=null)
                {
                    dem++;
                }
                n=dem;
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(DSPhieuDatHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSPhieuDatHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
    public void docDSHD()
    {
        try 
        {
            FileInputStream file = new FileInputStream("D:/ChuongTrinh/InputDSPDH.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line =null;
            try 
            {
                n=demPDH();
                dspdh=new PhieuDatHang[n];
                int i=0;
                while((line = buffer.readLine())!=null)
                {
                    dspdh[i]= new PhieuDatHang();
                    dspdh[i].xuly(line);
                    i++;
                }
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(DSPhieuDatHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSPhieuDatHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void xuatPDH()
    {
        System.out.println("==========================================================================================");
        System.out.printf("%-5s %-25s %-25s %-36s %-20s %-15s %-10s %-15s\n"
        ,"STT","Ma phieu dat hang","Ten khach hang","Dia chi","So dien thoai","Ma san pham","So luong","Ngay dat hang");
        for(int i=0;i<n;i++)
        {
            dspdh[i].xuatPDH();
        }
    }
    public void capNhatDSPDH()
    {
        FileOutputStream fos=null;
        try 
        {
            fos = new FileOutputStream("D:/ChuongTrinh/InputDSPDH.txt");
            for(int i=0;i<n;i++)
            {
                String line = dspdh[i].xulyLuu();
                try 
                {
                    byte []infor= line.getBytes("utf8");
                    try 
                    {
                        fos.write(infor);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(DSPhieuDatHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                catch (UnsupportedEncodingException ex) 
                {
                    Logger.getLogger(DSPhieuDatHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Cap nhat du lieu thanh cong !!!");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSPhieuDatHang.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(DSPhieuDatHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void themPDH(PhieuDatHang phd)
    {
        dspdh=Arrays.copyOf(dspdh, n+1);
        for(int i=0;i<n+1;i++)
        {
            if(i==n)
            {
                dspdh[i]=phd;
            }
        }
        n++;
        capNhatDSPDH();
    }
    public void xoaPDH()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma phieu dat hang can xoa: ");
            a=sc.nextLine();
            String check="^PDH[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key= dspdh[i].getMaPDH();
            if( key.contentEquals(a)== true)
            {
                for(int j=i;j<n-1;j++)
                {
                    dspdh[j]=dspdh[j+1];
                }
                n--;
                dspdh=Arrays.copyOf(dspdh, n);
            }
        }
        capNhatDSPDH();
    }
    public void suaPDH()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma phieu dat hang can sua: ");
            a=sc.nextLine();
            String check="^PDH[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key=dspdh[i].getMaPDH();
            if(key.contentEquals(a)==true)
            {
                PhieuDatHang pdh=new PhieuDatHang();
                System.out.println("Nhap thong tin phieu dat hang");
                pdh.nhapPDH();
                dspdh[i]=pdh;
            }
        }
        capNhatDSPDH();
    }
    public void timkiemPDH()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma phieu dat hang can tim: ");
            a=sc.nextLine();
            String check="^PDH[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key = dspdh[i].getMaPDH();
            if(key.contentEquals(a)==true)
            {
                System.out.println("==========================================================================================");
                System.out.printf("%-5s %-25s %-25s %-36s %-20s %-15s %-10s %-15s\n"
                    ,"STT","Ma phieu dat hang","Ten khach hang","Dia chi","So dien thoai","Ma san pham","So luong","Ngay dat hang");
                dspdh[i].xuatPDH();
                break;
            }
        }
    }
}
