/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

/**
 *
 * @author HP ADMIN
 */

public class NVGiaoHang extends NhanVien implements LoaiNhanVien{
    @Override
    public void ChucVu()
    {
        chucvu="Nv giao hang";
    }
    @Override
    public void Luong()
    {
        luong="8.000.000vnd";
    }
}
