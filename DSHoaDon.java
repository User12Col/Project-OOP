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

/**
 *
 * @author HP ADMIN
 */
public class DSHoaDon {
    Scanner sc=new Scanner(System.in);
    private int n;
    private HoaDon []dshd;
    public DSHoaDon()
    {
        n=0;
        dshd=null;
    }
    public int demHD()
    {
        int dem=0;
        try 
        {
            FileInputStream file = new FileInputStream("D:/ChuongTrinh/InputDSHD.txt");
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
                Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
    public void docDSHD()
    {
        try 
        {
            FileInputStream file = new FileInputStream("D:/ChuongTrinh/InputDSHD.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line =null;
            try 
            {
                n=demHD();
                dshd=new HoaDon[n];
                int i=0;
                while((line = buffer.readLine())!=null)
                {
                    dshd[i]= new HoaDon();
                    dshd[i].xuly(line);
                    i++;
                }
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void capNhatDSHD()
    {
        FileOutputStream fos=null;
        try 
        {
            fos = new FileOutputStream("D:/ChuongTrinh/InputDSHD.txt");
            for(int i=0;i<n;i++)
            {
                String line = dshd[i].xylyLuu();
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
    public void themHD(HoaDon hd)
    {
        dshd=Arrays.copyOf(dshd, n+1);
        for(int i=0;i<n+1;i++)
        {
            if(i==n)
            {
                dshd[i]=hd;
            }
        }
        n++;
        capNhatDSHD();
    }
    public void xoaHD()
    {
        System.out.println("Nhap ma hoa don can xoa: ");
        String a=sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String key= dshd[i].getMaHD();
            if( key.contains(a)== true)
            {
                for(int j=i;j<n-1;j++)
                {
                    dshd[j]=dshd[j+1];
                }
                n--;
                dshd=Arrays.copyOf(dshd, n);
            }
        }
        capNhatDSHD();
    }
    public void suaHD()
    {
        System.out.println("Nhap ma hoa don can sua: ");
        String a= sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String key=dshd[i].getMaHD();
            if(key.contains(a)==true)
            {
                HoaDon hd=new HoaDon();
                System.out.println("Nhap thong tin hoa don");
                hd.nhapHD();
                dshd[i]=hd;
            }
        }
        capNhatDSHD();
    }
    public void timkiemHD()
    {
        System.out.println("Nhap ma hoa don can tim kiem: ");
        String a = sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String key = dshd[i].getMaHD();
            if(key.contains(a)==true)
            {
                dshd[i].xuatHD();
                break;
            }
        }
    }
    public void xuatDSHD()
    {
        System.out.println("====================================================================================");
        System.out.printf("%-5s %-15s %-25s %-36s %-20s %-25s %-15s %-25s %-10s %-20s\n"
            ,"STT","Ma hoa don","Ten khach hang","Dia chi khach hang","Ngay lap hoa don","Nhan vien lap hoa don","Ma san pham","Ten san pham","So luong","Gia tien");
        for(int i=0;i<n;i++)
        {
            dshd[i].xuatHD();
        }
    }
}
