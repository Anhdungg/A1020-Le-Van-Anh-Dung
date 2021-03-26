package models;

public class BenhAnThuong extends BenhAn {
    String phiNamVien;

    public BenhAnThuong(String stt, String idBenhAn, String nameBenhAn, String tenBenhNhan, String ngayNhapVien,
                        String ngayRaVien, String lyDoNhapVien, String phiNamVien) {
        super(stt, idBenhAn, nameBenhAn, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public String getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(String phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String showInformation() {
        return super.showInformation() + ", Phí nằm viện: " + this.phiNamVien;
    }

    @Override
    public String toString() {
        return this.showInformation() + "\n";
    }
}
