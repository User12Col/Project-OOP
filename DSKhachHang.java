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
public class DSKhachHang {
    Scanner sc= new Scanner(System.in);
    private int n;
    private KhachHang []dskh;
    public DSKhachHang()
    {
        n=0;
        dskh=null;
    }
    public void docDSKH()
    {
        try 
        {
            FileInputStream file= new FileInputStream("D:/ChuongTrinh/InputDSKH.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line=null;
            int dem=0;
            try 
            {
                n=demKH();
                dskh=new KhachHang[n];
                int i=0;
                while((line = buffer.readLine())!=null)
                {
                    dskh[i]=new KhachHang();
                    dskh[i].xuly(line);
                    i++;
                }
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int demKH()
    {
        int dem=0;
        try 
        {
            FileInputStream file= new FileInputStream("D:/ChuongTrinh/InputDSKH.txt");
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
                Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
    public void capNhatDSKH()
    {
        FileOutputStream fos=null;
        try 
        {
            fos = new FileOutputStream("D:/ChuongTrinh/InputDSKH.txt");
            for(int i=0;i<n;i++)
            {
                String line = dskh[i].xylyLuu();
                try 
                {
                    byte []infor= line.getBytes("utf8");
                    try 
                    {
                        fos.write(infor);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                catch (UnsupportedEncodingException ex) 
                {
                    Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Cap nhat du lieu thanh cong !!!");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void themKH(KhachHang kh)
    {
        dskh=Arrays.copyOf(dskh, n+1);
        for(int i=0;i<n+1;i++)
        {
            if(i==n)
            {
                dskh[i]=kh;
            }
        }
        n++;
        capNhatDSKH();
    }
    public void suaKH()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma khach hang can sua: ");
            a=sc.nextLine();
            String check="^KH[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key=dskh[i].getMaKH();
            if(key.contentEquals(a)==true)
            {
                KhachHang kh=new KhachHang();
                System.out.println("Nhap thong tin khach hang");
                kh.nhapKH();
                dskh[i]=kh;
            }
        }
        capNhatDSKH();
    }
    public void timkiemKH()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma khach hang can tim: ");
            a=sc.nextLine();
            String check="^KH[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key = dskh[i].getMaKH();
            if(key.contentEquals(a)==true)
            {
                System.out.println("====================================================");
                System.out.printf("%-10s %-10s %-25s %-40s %-15s\n"
                    ,"STT","Ma KH","Ho ten","Dia chi","So dien thoai");
                dskh[i].xuatKH();
                break;
            }
        }
    }
    public void xoaKH()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma khach hang can xoa: ");
            a=sc.nextLine();
            String check="^KH[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key= dskh[i].getMaKH();
            if( key.contentEquals(a)== true)
            {
                for(int j=i;j<n-1;j++)
                {
                    dskh[j]=dskh[j+1];
                }
                n--;
                dskh=Arrays.copyOf(dskh, n);
            }
        }
        capNhatDSKH();
    }
    public void xuatDSKH()
    {
        System.out.println("====================================================");
        System.out.printf("%-10s %-10s %-25s %-40s %-15s\n"
            ,"STT","Ma KH","Ho ten","Dia chi","So dien thoai");
        for(int i=0;i<n;i++)
        {
            dskh[i].xuatKH();
        }
    }
}
