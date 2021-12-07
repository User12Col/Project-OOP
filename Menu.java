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
public class Menu {
    Scanner sc=new Scanner(System.in);
    public void mainMenu()
    {
        int chon;
        do
        {
            System.out.println("=============================================");
            System.out.println("WELCOM TO MAIN MENU");
            System.out.println("1. Danh sach nhan vien");
            System.out.println("2. Danh sach khach hang");
            System.out.println("3. Danh sach hoa don");
            System.out.println("4. Danh sach phieu dat hang");
            System.out.println("5. Danh sach phieu giao hang");
            System.out.println("6. Danh sach san pham");
            System.out.println("7. Danh sach phieu bao hanh");
            System.out.println("-1. Thoat");
            System.out.println("Chon yeu cau: ");
            chon=sc.nextInt();
            switch(chon)
            {
                case 1: 
                    dsnvMenu();
                    break;
                case 2:
                    dskhMenu();
                    break;
                case 3:
                    dshdMenu();
                    break;
                case 4:
                    dspdhMenu();
                    break;
                case 5:
                    dspghMenu();
                    break;
                case 6:
                    dsspMenu();
                    break;
                case 7:
                    dspbhMenu();
                    break;
            }
        }
        while(chon != -1);
    }
    public void dsnvMenu()
    {
        int chon1;
        do
        {
            System.out.println("============================================");
            System.out.println("WELCOM TO MENU of DANH SACH NHAN VIEN");
            System.out.println("1. Xuat danh sach nhan vien");
            System.out.println("2. Them nhan vien");
            System.out.println("3. Xoa nhan vien");
            System.out.println("4. Sua thong tin nhan vien");
            System.out.println("5. Tim kiem");
            System.out.println("-1. Thoat");
            System.out.println("Chon yeu cau: ");
            chon1=sc.nextInt();
            DSNhanVien dsnv= new DSNhanVien();
            dsnv.docDSNV();
            switch(chon1)
            {
                case 1:
                    System.out.println("==============================================");
                    dsnv.xuatDSNV();
                    break;
                case 2:
                    int chonNV;
                    do
                    {
                        System.out.println("==================================================");
                        System.out.println("1. Them nhan vien ban hang: ");
                        System.out.println("2. Them nhan vien giao hang: ");
                        System.out.println("3. Them nhan vien quan ly: ");
                        System.out.println("-1. Thoat");
                        System.out.println("Chon yeu cau: ");
                        chonNV=sc.nextInt();
                        switch(chonNV)
                        {
                            case 1:
                                NhanVien nv1=new NVBanHang();
                                nv1.nhapNV();
                                nv1.ChucVu();
                                nv1.Luong();
                                dsnv.themNV(nv1);
                                break;
                            case 2:
                                NhanVien nv2= new NVGiaoHang();
                                nv2.nhapNV();
                                nv2.ChucVu();
                                nv2.Luong();
                                dsnv.themNV(nv2);
                                break;
                            case 3:
                                NhanVien nv3=new NVQuanLy();
                                nv3.nhapNV();
                                nv3.ChucVu();
                                nv3.Luong();
                                dsnv.themNV(nv3);
                                break;
                        } 
                    }
                    while(chonNV != -1);
                    break;
                case 3:
                    dsnv.xoaNV();
                    break;
                case 4:
                    dsnv.suaNV();
                    break;
                case 5:
                    dsnv.timkiemNV();
                    break;
            }
        }
        while(chon1 != -1);
    }
    public void dskhMenu()
    {
        int chon2;
        do
        {
            System.out.println("============================================");
            System.out.println("WELCOM TO MENU of DANH SACH KHACH HANG");
            System.out.println("1. Xuat danh sach kahch hang");
            System.out.println("2. Them khach hang");
            System.out.println("3. Xoa khach hang");
            System.out.println("4. Sua thong tin khach hang");
            System.out.println("5. Tim kiem");
            System.out.println("-1. Thoat");
            System.out.println("Chon yeu cau: ");
            chon2=sc.nextInt();
            DSKhachHang ds=new DSKhachHang();
            ds.docDSKH();
            switch(chon2)
            {
                case 1:
                    ds.xuatDSKH();
                    break;
                case 2:
                    KhachHang kh= new KhachHang();
                    kh.nhapKH();
                    ds.themKH(kh);
                    break;
                case 3:
                    ds.xoaKH();
                    break;
                case 4:
                    ds.suaKH();
                    break;
                case 5:
                    ds.timkiemKH();
                    break;
            }
        }
        while(chon2 != -1);
    }
    public void dshdMenu()
    {
        int chon3;
        do
        {
            System.out.println("============================================");
            System.out.println("WELCOM TO MENU of DANH SACH HOA DON");
            System.out.println("1. Xuat danh sach hoa don");
            System.out.println("2. Them hoa don");
            System.out.println("3. Xoa hoa don");
            System.out.println("4. Sua thong tin hoa don");
            System.out.println("5. Tim kiem");
            System.out.println("-1. Thoat");
            System.out.println("Chon yeu cau: ");
            chon3=sc.nextInt();
            DSHoaDon dshd=new DSHoaDon();
            dshd.docDSHD();
            switch(chon3)
            {
                case 1:
                    dshd.xuatDSHD();
                    break;
                case 2:
                    HoaDon hd= new HoaDon();
                    hd.nhapHD();
                    dshd.themHD(hd);
                    break;
                case 3:
                    dshd.xoaHD();
                    break;
                case 4:
                    dshd.suaHD();
                    break;
                case 5:
                    dshd.timkiemHD();
                    break;
            }
        }
        while(chon3 != -1);
    }
    public void dspdhMenu()
    {
        int chon4;
        do
        {
            System.out.println("============================================");
            System.out.println("WELCOM TO MENU of DANH SACH PHIEU DAT HANG");
            System.out.println("1. Xuat danh sach phieu dat hang");
            System.out.println("2. Them phieu dat hang");
            System.out.println("3. Xoa phieu dat hang");
            System.out.println("4. Sua thong tin phieu dat hang");
            System.out.println("5. Tim kiem");
            System.out.println("-1. Thoat");
            System.out.println("Chon yeu cau: ");
            chon4=sc.nextInt();
            DSPhieuDatHang dspdh=new DSPhieuDatHang();
            dspdh.docDSHD();
            switch(chon4)
            {
                case 1:
                    dspdh.xuatPDH();
                    break;
                case 2:
                    PhieuDatHang pdh = new PhieuDatHang();
                    pdh.nhapPDH();
                    dspdh.themPDH(pdh);
                    break;
                case 3:
                    dspdh.xoaPDH();
                    break;
                case 4:
                    dspdh.suaPDH();
                    break;
                case 5:
                    dspdh.timkiemPDH();
                    break;
            }
        }
        while(chon4 != -1);
    }
    public void dspghMenu()
    {
        int chon5;
        do
        {
            System.out.println("============================================");
            System.out.println("WELCOM TO MENU of DANH SACH PHIEU GIAO HANG");
            System.out.println("1. Xuat danh sach phieu giao hang");
            System.out.println("2. Them phieu giao hang");
            System.out.println("3. Xoa phieu giao hang");
            System.out.println("4. Sua thong tin phieu giao hang");
            System.out.println("5. Tim kiem");
            System.out.println("-1. Thoat");
            System.out.println("Chon yeu cau: ");
            chon5=sc.nextInt();
            DSPhieuGiaoHang dspgh=new DSPhieuGiaoHang();
            dspgh.docDSPGH();
            switch(chon5)
            {
                case 1:
                    dspgh.xuatDSPGH();
                    break;
                case 2:
                    PhieuGiaoHang pgh = new PhieuGiaoHang();
                    pgh.nhapPGH();
                    dspgh.themPGH(pgh);
                    break;
                case 3:
                    dspgh.xoaPGH();
                    break;
                case 4:
                    dspgh.suaPGH();
                    break;
                case 5:
                    dspgh.timkiemPGH();
                    break;
            }
        }
        while(chon5 != -1);
    }
    public void dsspMenu()
    {
        int chon6;
        do
        {
            System.out.println("============================================");
            System.out.println("WELCOM TO MENU of DANH SACH SAN PHAM");
            System.out.println("1. Xuat danh sach san pham");
            System.out.println("2. Them san pham");
            System.out.println("3. Xoa san pham");
            System.out.println("4. Sua thong tin san pham");
            System.out.println("5. Tim kiem");
            System.out.println("-1. Thoat");
            System.out.println("Chon yeu cau: ");
            chon6=sc.nextInt();
            DSSanPham ds=new DSSanPham();
            ds.docDSSP();
            switch(chon6)
            {
                case 1:
                    ds.xuatDSSP();
                    break;
                case 2:
                    SanPham sp = new SanPham();
                    sp.nhapSP();
                    ds.themSP(sp);
                    break;
                case 3:
                    ds.xoaSP();
                    break;
                case 4:
                    ds.suaSP();
                    break;
                case 5:
                    ds.timkiemSp();
                    break;
            }
        }
        while(chon6 != -1);
    }
    public void dspbhMenu()
    {
        int chon7;
        do
        {
            System.out.println("===================================================");
            System.out.println("WELCOM TO MENU of DANH SACH PHIEU BAO HANH");
            System.out.println("1. Xuat danh sach phieu bao hanh");
            System.out.println("2. Them phieu bao hanh");
            System.out.println("3. Xoa phieu bao hanh");
            System.out.println("4. Sua thong tin phieu bao hanh");
            System.out.println("5. Tim kiem");
            System.out.println("-1. Thoat");
            System.out.println("Chon yeu cau: ");
            chon7 =sc.nextInt();
            DSPhieuBaoHanh dspbh= new DSPhieuBaoHanh();
            dspbh.docDSPBH();
            switch(chon7)
            {
                case 1: 
                    dspbh.xuatDSPBH();
                    break;
                case 2:
                    PhieuBaoHanh pbh= new PhieuBaoHanh();
                    pbh.nhapPBH();
                    dspbh.themPBH(pbh);
                    break;
                case 3:
                    dspbh.xoaPHB();
                    break;
                case 4:
                    dspbh.suaPBH();
                    break;
                case 5:
                    dspbh.xuatDSPBH();
                    break;
            }
        }
        while(chon7 != -1);
    }
    
}
