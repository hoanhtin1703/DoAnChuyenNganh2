-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 28, 2023 lúc 05:01 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bookstore`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_danh_gia`
--

CREATE TABLE `bang_danh_gia` (
  `ma_danh_gia` int(11) NOT NULL,
  `so_sao` int(11) DEFAULT NULL,
  `noi_dung` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT NULL,
  `ma_khach_hang` int(11) DEFAULT NULL,
  `ma_san_pham` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_don_hang`
--

CREATE TABLE `bang_don_hang` (
  `ma_dat_hang` varchar(255) NOT NULL,
  `dia_chi_giao_hang` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` int(11) DEFAULT NULL,
  `ma_thanh_toan` int(11) DEFAULT NULL,
  `ngay_dat_hang` varchar(255) DEFAULT NULL,
  `ngay_giao_hang` varchar(255) DEFAULT NULL,
  `tong_tien` bigint(20) DEFAULT NULL,
  `trang_thai_don_hang` int(11) DEFAULT NULL,
  `ma_nguoi_dung` int(11) DEFAULT NULL,
  `so_dien_thoai_nguoi_nhan` varchar(255) DEFAULT NULL,
  `ten_nguoi_nhan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bang_don_hang`
--

INSERT INTO `bang_don_hang` (`ma_dat_hang`, `dia_chi_giao_hang`, `ma_nhan_vien`, `ma_thanh_toan`, `ngay_dat_hang`, `ngay_giao_hang`, `tong_tien`, `trang_thai_don_hang`, `ma_nguoi_dung`, `so_dien_thoai_nguoi_nhan`, `ten_nguoi_nhan`) VALUES
('l4n00olzgj', 'a', 0, 1, '28/12/2023', '01/01/2024', 220000, 2, 16, 'a', 'a'),
('rzgbl38jls', 'b', NULL, 1, '28/12/2023', '01/01/2024', 100000, 0, 16, 'b', 'b'),
('ufmo6kiwbi', '123', NULL, 1, '28/12/2023', '01/01/2024', 240000, 0, 16, '09', 'Tín'),
('vkx4ona6kz', 'a', NULL, 1, '28/12/2023', '01/01/2024', 500000, 0, 16, 'â', 'a'),
('ymvyucr200', 'Huế', 0, 1, '27/12/2023', '31/12/2023', 170000, 2, 16, '0935640559', 'Trần Tiến');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_don_hang_chi_tiet`
--

CREATE TABLE `bang_don_hang_chi_tiet` (
  `ma_don_hang_chi_tiet` int(11) NOT NULL,
  `gia` bigint(20) DEFAULT NULL,
  `ma_dat_hang` varchar(255) DEFAULT NULL,
  `ma_san_pham` int(11) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bang_don_hang_chi_tiet`
--

INSERT INTO `bang_don_hang_chi_tiet` (`ma_don_hang_chi_tiet`, `gia`, `ma_dat_hang`, `ma_san_pham`, `so_luong`) VALUES
(6, 250000, 'l4n00olzgj', 37, 1),
(7, 130000, 'rzgbl38jls', 34, 1),
(8, 140000, 'ufmo6kiwbi', 33, 1),
(9, 130000, 'ufmo6kiwbi', 34, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_giam_gia`
--

CREATE TABLE `bang_giam_gia` (
  `ma_giam_gia` int(11) NOT NULL,
  `phan_tram_giam` int(11) DEFAULT NULL,
  `ten_giam_gia` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_hinh_anh_san_pham`
--

CREATE TABLE `bang_hinh_anh_san_pham` (
  `ma_hinh_anh` int(11) NOT NULL,
  `duong_dan` varchar(255) DEFAULT NULL,
  `ma_san_pham` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bang_hinh_anh_san_pham`
--

INSERT INTO `bang_hinh_anh_san_pham` (`ma_hinh_anh`, `duong_dan`, `ma_san_pham`) VALUES
(25, 'dem_nay_co_ruou_1.1.jpg', 6),
(26, 'dem_nay_co_ruou_1.2.jpg', 6),
(27, 'dem_nay_co_ruou_1.3.jpg', 6),
(28, 'dem_nay_co_ruou_2.1.jpg', 19),
(29, 'dem_nay_co_ruou_2.2.jpg', 19),
(30, 'dem_nay_co_ruou_2.3.jpg', 19),
(31, 'treu_nham_1.1.jpg', 8),
(32, 'treu_nham_1.2.jpg', 8),
(33, 'treu_nham_1.3.jpg', 8),
(34, 'treu_nham_2.1.jpg', 18),
(35, 'treu_nham_2.2.jpg', 18),
(36, 'treu_nham_2.3.jpg', 18),
(37, 'da_nhieu_nam_nhu_the_1.2.jpg', 20),
(38, 'da_nhieu_nam_nhu_the_1.1.jpg', 20),
(39, 'da_nhieu_nam_nhu_the_1.3.jpg', 20),
(40, 'da_nhieu_nam_nhu_the_2.1.jpg', 21),
(41, 'da_nhieu_nam_nhu_the_2.2.jpg', 21),
(42, 'da_nhieu_nam_nhu_the_2.3.jpg', 21),
(43, '8_vu_an_hoan_hao_1.jpg', 22),
(44, '8_vu_an_hoan_hao_2.jpg', 22),
(45, '8_vu_an_hoan_hao_3.jpg', 22),
(46, 'si_so_lop_vang_0_1.jpg', 23),
(47, 'si_so_lop_vang_0_2.jpg', 23),
(48, 'si_so_lop_vang_0_3.jpg', 23),
(49, 'tam_ly_hoc_toi_pham_1.jpg', 25),
(50, 'tam_ly_hoc_toi_pham_2.jpg', 25),
(51, 'tam_ly_hoc_toi_pham_3.jpg', 25),
(52, 'the_gioi_ben_trong_cai_ac_1.jpg', 26),
(53, 'the_gioi_ben_trong_cai_ac_2.jpg', 26),
(54, 'the_gioi_ben_trong_cai_ac_3.jpg', 26),
(55, 'thien_tai_ben_trai_ke_dien_ben_phai_1.jpg', 27),
(56, 'thien_tai_ben_trai_ke_dien_ben_phai_2.jpg', 27),
(57, 'thien_tai_ben_trai_ke_dien_ben_phai_3.jpg', 27),
(58, 'thoat_khoi_bay_nhan_cach_1.jpg', 28),
(59, 'thoat_khoi_bay_nhan_cach_2.jpg', 28),
(60, 'thoat_khoi_bay_nhan_cach_3.jpg', 28),
(61, 'vuon_hoa_mat_duoc_ky_su_1.jpg', 29),
(62, 'vuon_hoa_mat_duoc_ky_su_2.jpg', 29),
(63, 'vuon_hoa_mat_duoc_ky_su_3.jpg', 29),
(64, 'em_la_tieu_tien_nu_cua_anh_tap_1.1.jpg', 30),
(65, 'em_la_tieu_tien_nu_cua_anh_tap_1.2.jpg', 30),
(66, 'em_la_tieu_tien_nu_cua_anh_tap_1.3.jpg', 30),
(67, 'em_la_tieu_tien_nu_cua_anh_tap_2.1.jpg', 31),
(68, 'em_la_tieu_tien_nu_cua_anh_tap_2.2.jpg', 31),
(69, 'em_la_tieu_tien_nu_cua_anh_tap_2.3.jpg', 31),
(70, 'hay_nham_mat_khi_anh_den_1.1.jpg', 32),
(71, 'hay_nham_mat_khi_anh_den_1.2.jpg', 32),
(72, 'hay_nham_mat_khi_anh_den_1.3.jpg', 32),
(73, 'hay_nham_mat_khi_anh_den_2.1.jpg', 33),
(74, 'hay_nham_mat_khi_anh_den_2.2.webp', 33),
(75, 'hay_nham_mat_khi_anh_den_2.3.jpg', 33),
(76, 'uong_nham_mot_anh_mat_con_say_theo_ca_doi_1.1.jpg', 34),
(77, 'uong_nham_mot_anh_mat_con_say_theo_ca_doi_1.2.jpg', 34),
(78, 'uong_nham_mot_anh_mat_con_say_theo_ca_doi_1.3.jpg', 34),
(79, 'uong_nham_mot_anh_mat_con_say_theo_ca_doi_2.1.jpg', 35),
(80, 'uong_nham_mot_anh_mat_con_say_theo_ca_doi_2.2.jpg', 35),
(81, 'uong_nham_mot_anh_mat_con_say_theo_ca_doi_2.3.jpg', 35),
(82, 'kho_do_danh_1.1.jpg', 36),
(83, 'kho_do_danh_1.2.jpg', 36),
(84, 'kho_do_danh_1.3.jpg', 36),
(85, 'kho_do_danh_2.1.jpg', 37),
(86, 'kho_do_danh_2.2.jpg', 37),
(87, 'kho_do_danh_2.3.jpg', 37),
(88, 'khong_phai_soi_nhung_cung_dung_la_cuu_1.jpg', 24),
(89, 'khong_phai_soi_nhung_cung_dung_la_cuu_2.jpg', 24),
(90, 'khong_phai_soi_nhung_cung_dung_la_cuu_3.jpg', 24);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_nguoi_dung`
--

CREATE TABLE `bang_nguoi_dung` (
  `ma_nguoi_dung` int(11) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `loai_tai_khoan` int(11) DEFAULT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `ten_nguoi_dung` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bang_nguoi_dung`
--

INSERT INTO `bang_nguoi_dung` (`ma_nguoi_dung`, `dia_chi`, `email`, `loai_tai_khoan`, `mat_khau`, `so_dien_thoai`, `ten_nguoi_dung`) VALUES
(16, NULL, 'tien@gmail.com', 2, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '09356xxxx', 'Trần Tiến'),
(17, NULL, 'hien@gmail.com', 1, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '090xxxxxx', 'Hiền'),
(18, NULL, 'hoa@gmail.com', 0, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, 'hoa'),
(19, 'Kom Tum', 'hin@gmail.com', 2, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '09xxxxxxx', 'Hiền Nguyễn'),
(20, 'Đà Nẵng', 'tin@gmail.com', 2, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '0901xxxxx', 'Tín Hồ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_nha_cung_cap`
--

CREATE TABLE `bang_nha_cung_cap` (
  `ma_nha_cung_cap` int(11) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `ten_nha_cung_cap` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_san_pham`
--

CREATE TABLE `bang_san_pham` (
  `ma_san_pham` int(11) NOT NULL,
  `gia_ban` bigint(20) DEFAULT NULL,
  `gia_nhap` bigint(20) DEFAULT NULL,
  `ma_the_loai` int(11) DEFAULT NULL,
  `mo_ta` text DEFAULT NULL,
  `so_luong_trong_kho` int(11) DEFAULT NULL,
  `ten_san_pham` varchar(255) DEFAULT NULL,
  `the_san_pham` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT NULL,
  `giam_gia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bang_san_pham`
--

INSERT INTO `bang_san_pham` (`ma_san_pham`, `gia_ban`, `gia_nhap`, `ma_the_loai`, `mo_ta`, `so_luong_trong_kho`, `ten_san_pham`, `the_san_pham`, `trang_thai`, `giam_gia`) VALUES
(6, 100000, 50000, 1, 'Lần đầu tiên gặp cô, anh nhìn thấy Trần Phi đang đứng ngay giữa đường, thân thể của người thiếu nữ hoàn toàn trần trụi, từ trên xuống dưới điều bị lột sạch chẳng sót lại gì, mái tóc lòa xòa, có vài cọng rơi bên chân, còn có một bãi nôn trên mặt đất cách cô không quá xa.\n...\nTiêu Sách tính toán thời gian ước chừng việc xâm hại còn chưa diễn ra.\n...\nDo sự ngạc nhiên còn lớn hơn lo lắng, anh bất giác sững người cách Trần Phi năm mét. Dường như người thiếu nữ đó không hề sợ anh, vẫn đàng hoàng đứng đó, thậm chí không đưa tay che chắn gì, giọng thậm chí còn còn lạnh hơn cả nhiệt độ ngoài trời lúc ấy: \"Anh là ai?\"', 10, 'Đêm Nay Có Rượu 1', 'dem nay co ruou', 0, 10),
(8, 500000, 200000, 1, 'Muốn bớt hai mươi năm phấn đấu ư? Nằm mơ đi.\n\nCòn muốn kết thân với tôi? Được, tôi đây sẽ tới làm mợ trẻ của các người.\n\nĐể lúc nào các người cũng phải cung kính nịnh nọt tôi.\n\nMột khắc kia, không biết Trịnh Thư Ý lấy tự tin ở đâu ra, nở nụ cười yêu kiều gõ cửa kính ghế sau xe Rolls Royce.\n\nCửa kính chậm rãi hạ xuống, người đàn ông trẻ tuổi nhìn ra, đôi mắt phía sau cặp kính thâm thúy mê người.\n\nTrong lòng Trịnh Thư Ý chấn động: Bạch liên hoa kia lớn lên chẳng ra gì thế mà cậu trẻ của cô ta lại đẹp trai như vậy?\n\nNếu là fan của Kiều Diêu, bạn có thể đọc thêm Cưa Nhầm Bạn Trai, Được Chồng Như Ý hay Hạ Cánh Trên Trái Tim Anh.', 20, 'Trêu Nhầm Tập 1', 'treu nham tap 1', 0, 0),
(18, 200000, 100000, 1, 'Muốn bớt hai mươi năm phấn đấu ư? Nằm mơ đi.\n\nCòn muốn kết thân với tôi? Được, tôi đây sẽ tới làm mợ trẻ của các người.\n\nĐể lúc nào các người cũng phải cung kính nịnh nọt tôi.\n\nMột khắc kia, không biết Trịnh Thư Ý lấy tự tin ở đâu ra, nở nụ cười yêu kiều gõ cửa kính ghế sau xe Rolls Royce.\n\nCửa kính chậm rãi hạ xuống, người đàn ông trẻ tuổi nhìn ra, đôi mắt phía sau cặp kính thâm thúy mê người.\n\nTrong lòng Trịnh Thư Ý chấn động: Bạch liên hoa kia lớn lên chẳng ra gì thế mà cậu trẻ của cô ta lại đẹp trai như vậy?\n\nNếu là fan của Kiều Diêu, bạn có thể đọc thêm Cưa Nhầm Bạn Trai, Được Chồng Như Ý hay Hạ Cánh Trên Trái Tim Anh.', 10, 'Trêu Nhầm Tập 2', 'treu nham tap 2', 0, 10),
(19, 300000, 150000, 1, 'Lần đầu tiên gặp cô, anh nhìn thấy Trần Phi đang đứng ngay giữa đường, thân thể của người thiếu nữ hoàn toàn trần trụi, từ trên xuống dưới điều bị lột sạch chẳng sót lại gì, mái tóc lòa xòa, có vài cọng rơi bên chân, còn có một bãi nôn trên mặt đất cách cô không quá xa.\n...\nTiêu Sách tính toán thời gian ước chừng việc xâm hại còn chưa diễn ra.\n...\nDo sự ngạc nhiên còn lớn hơn lo lắng, anh bất giác sững người cách Trần Phi năm mét. Dường như người thiếu nữ đó không hề sợ anh, vẫn đàng hoàng đứng đó, thậm chí không đưa tay che chắn gì, giọng thậm chí còn còn lạnh hơn cả nhiệt độ ngoài trời lúc ấy: \"Anh là ai?\"', 10, 'Đêm Nay Có Rượu Tập 2', 'dem nay co ruou tap 2', 0, 10),
(20, 130000, 100000, 1, 'Câu chuyện về mối tình giữa một tiểu nữ sinh và một đại nam sinh trong ngôi trường cấp Ba Chấn Hoa. Bộ sách theo dõi họ qua những thăng trầm, thách thức và sự trưởng thành, đặt câu hỏi liệu họ có kiên trì với tình cảm của mình không. ', 9, 'Đã Nhiều Năm Như Thế Tập 1', 'da nhieu nam nhu the tap 1', 0, 10),
(21, 140000, 110000, 1, 'Câu chuyện về mối tình giữa một tiểu nữ sinh và một đại nam sinh trong ngôi trường cấp Ba Chấn Hoa. Bộ sách theo dõi họ qua những thăng trầm, thách thức và sự trưởng thành, đặt câu hỏi liệu họ có kiên trì với tình cảm của mình không. ', 9, 'Đã Nhiều Năm Như Thế Tập 2', 'da nhieu nam nhu the tap 2', 0, 10),
(22, 150000, 120000, 2, 'Cuốn sách \"8 Vụ Án Hoàn Hảo\" của Peter Swanson kể về Malcolm Kershaw, người viết danh sách \"8 vụ g.iết người hoàn hảo\" từ truyện trinh thám kinh điển. Khi có kẻ giết người bắt chước danh sách của anh, Malcolm phải tìm ra kẻ thực sự để bảo vệ bản thân.', 10, '8 Vụ Án Hoàn Hảo', '8 vu an hoan hao', 0, 15),
(23, 130000, 100000, 2, '\"Sĩ Số Lớp Vắng 0\" đưa độc giả đến ngôi trường kinh hoàng với những đồn đại và trải nghiệm kinh hoàng của nhân vật trong câu chuyện. Sự ám ảnh và bí ẩn trong lớp học tạo nên một cuộc phiêu lưu đen tối.', 10, 'Sĩ Số Lớp Vắng 0', 'si so lop vang 0', 0, 12),
(24, 160000, 120000, 2, '\"Không Phải Sói Nhưng Cũng Đừng Là Cừu\" của tác giả Lê Bảo Ngọc là một cuốn sách độc đáo, giúp định hướng cho người đọc về cách sống và làm việc một cách hiệu quả mà không cần trở thành \"sói\" hay \"cừu\".', 15, 'Không Phải Sói Nhưng Cũng Đừng Là Cừu', 'khong phai soi nhung cung dung la cuu', 2, 10),
(25, 140000, 90000, 2, '\"Tâm Lý Học Tội Phạm\" là tuyển tập 36 vụ án kinh điển của FBI, giúp khám phá tâm lý và hành vi của kẻ phạm tội, mang lại những câu chuyện rợn tóc gáy về tội ác và cuộc đấu trí giữa điều tra viên và tội phạm. ', 15, 'Tâm Lý Học Tội Phạm', 'tam ly hoc toi pham', 0, 30),
(26, 160000, 120000, 2, '\"Phân Tích Tâm Lý Tội Phạm - Thế Giới Bên Trong Cái Ác\" của Trương Úy là một tài liệu chuyên sâu về tâm lý học tội phạm, giúp hiểu sâu hơn về nguyên nhân của hành vi phi nhân tính trong tội phạm. ', 20, 'Thế Giới Bên Trong Cái Ác', 'the gioi ben trong cai ac', 2, 25),
(27, 200000, 150000, 2, '\"Thiên Tài Bên Trái Kẻ Điên Bên Phải\" là cuốn sách dành cho những người \"điên rồ\", những người nhìn thế giới khác biệt và tạo ra sự thay đổi. ', 20, 'Thiên Tài Bên Trái Kẻ Điên Bên Phải', 'thien tai ben trai ke dien ben phai', 2, 20),
(28, 220000, 170000, 2, '\"Thoát Khỏi Bẫy Nhân Cách\" giới thiệu khái niệm về \"sự kìm nén khả năng bản thân\" và cung cấp định luật phát triển tâm hồn để thoát khỏi những cạm bẫy trong nhân cách.', 25, 'Thoát Khỏi Bẫy Nhân Cách', 'thoat khoi bay nhan cach', 0, 15),
(29, 170000, 120000, 2, '\"Vườn Hoa Mạt Dược Ký Sự\" là một tài liệu thú vị về 15 kỳ án nghiêm trọng trên thế giới, giúp độc giả hiểu rõ hơn về các vụ án và điểm chung giữa chúng.', 15, 'Vườn Hoa Mạt Dược Ký Sự', 'vuon hoa mat duoc ky su', 2, 10),
(30, 230000, 180000, 1, 'Câu chuyện xoay quanh mối quan hệ giữa Trần Thuật và An Tĩnh. Trần Thuật đề xuất giúp đỡ An Tĩnh trong việc làm bài tập, tạo nên một mối quan hệ đặc biệt giữa họ. ', 50, 'Em Là Tiểu Tiên Nữ Của Anh Tập 1', 'em la tieu tien nu cua anh tap 1', 0, 20),
(31, 210000, 160000, 1, 'Câu chuyện xoay quanh mối quan hệ giữa Trần Thuật và An Tĩnh. Trần Thuật đề xuất giúp đỡ An Tĩnh trong việc làm bài tập, tạo nên một mối quan hệ đặc biệt giữa họ. ', 0, 'Em Là Tiểu Tiên Nữ Của Anh Tập 2', 'em la tieu tien nu cua anh tap 2', 2, 30),
(32, 130000, 100000, 1, 'Đinh Mặc mang đến một tác phẩm mới với đề tài tâm lý tội phạm ngôn tình. Mặc dù chưa đọc truyện, nhưng độc giả có thể kì vọng vào tài năng của Đinh Mặc và những tình huống bất ngờ và hấp dẫn. ', 40, 'Hãy Nhắm Mắt Khi Anh Đến', 'hay nham mat khi anh den', 0, 15),
(33, 140000, 100000, 1, 'Đinh Mặc mang đến một tác phẩm mới với đề tài tâm lý tội phạm ngôn tình. Mặc dù chưa đọc truyện, nhưng độc giả có thể kì vọng vào tài năng của Đinh Mặc và những tình huống bất ngờ và hấp dẫn. ', 40, 'Hãy Nhắm Mắt Khi Anh Đến Tập 2', 'Hãy Nhắm Mắt Khi Anh Đến Tập 2', 0, 10),
(34, 130000, 80000, 1, 'Một câu chuyện đầy bi kịch về tình yêu giữa một cô gái không may mắn và một chàng trai giàu có. Họ phải đối mặt với những thách thức từ gia đình và cuộc sống, và cố gắng tìm lại niềm tin và hạnh phúc. ', 30, 'Uống Nhầm Ánh Mắt Cơn Say Theo Cả Đời Tập 1', 'Uống Nhầm Ánh Mắt Cơn Say Theo Cả Đời Tập 1', 0, 20),
(35, 140000, 90000, 1, 'Một câu chuyện đầy bi kịch về tình yêu giữa một cô gái không may mắn và một chàng trai giàu có. Họ phải đối mặt với những thách thức từ gia đình và cuộc sống, và cố gắng tìm lại niềm tin và hạnh phúc. ', 30, 'Uống Nhầm Ánh Mắt Cơn Say Theo Cả Đời Tập 2', 'Uống Nhầm Ánh Mắt Cơn Say Theo Cả Đời Tập 2', 0, 18),
(36, 200000, 150000, 1, 'Tình cờ, Ôn Dĩ Phàm và bạn học Tang Diên thuê chung nhà. Sau một số sự hiểu lầm, họ đồng ý chung chăn gối nhưng Tang Diên yêu cầu trước khi ngủ phải khóa cửa. Khi Ôn Dĩ Phàm đồng ý, cô hỏi nếu không làm được gì khi chung gối, anh trả lời hài hước, tạo nên tình huống hóm hỉnh.', 50, 'Khó Dỗ Dành Tập 1', 'Khó Dỗ Dành Tập 1', 0, 12),
(37, 250000, 200000, 1, 'Tình cờ, Ôn Dĩ Phàm và bạn học Tang Diên thuê chung nhà. Sau một số sự hiểu lầm, họ đồng ý chung chăn gối nhưng Tang Diên yêu cầu trước khi ngủ phải khóa cửa. Khi Ôn Dĩ Phàm đồng ý, cô hỏi nếu không làm được gì khi chung gối, anh trả lời hài hước, tạo nên tình huống hóm hỉnh.', 25, 'Khó Dỗ Dành Tập 2', 'Khó Dỗ Dành Tập 2', 0, 15);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_san_pham_nha_cung_cap`
--

CREATE TABLE `bang_san_pham_nha_cung_cap` (
  `ma_nha_cung_cap` int(11) NOT NULL,
  `ma_san_pham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_thanh_toan`
--

CREATE TABLE `bang_thanh_toan` (
  `ma_thanh_toan` int(11) NOT NULL,
  `phuong_thuc_thanh_toan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bang_thanh_toan`
--

INSERT INTO `bang_thanh_toan` (`ma_thanh_toan`, `phuong_thuc_thanh_toan`) VALUES
(1, 'Thanh toán khi nhận hàng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_the_loai`
--

CREATE TABLE `bang_the_loai` (
  `ma_the_loai` int(11) NOT NULL,
  `ten_the_loai` varchar(255) DEFAULT NULL,
  `trang_thai_the_loai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bang_the_loai`
--

INSERT INTO `bang_the_loai` (`ma_the_loai`, `ten_the_loai`, `trang_thai_the_loai`) VALUES
(1, 'Ngôn Tình', 0),
(2, 'Trinh Thám', 0),
(26, 'Truyện Tranh', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bang_danh_gia`
--
ALTER TABLE `bang_danh_gia`
  ADD PRIMARY KEY (`ma_danh_gia`),
  ADD KEY `FKp7rp3cdbvce7gs4qo1qpp7dvt` (`ma_san_pham`),
  ADD KEY `FK3m37pivvc8abtxlpgub7np66s` (`ma_khach_hang`);

--
-- Chỉ mục cho bảng `bang_don_hang`
--
ALTER TABLE `bang_don_hang`
  ADD PRIMARY KEY (`ma_dat_hang`),
  ADD KEY `FKpxht1ntxhv32frnu9vcg1xn6i` (`ma_thanh_toan`),
  ADD KEY `FKmsxxscy1v5w6og90j38n8ya92` (`ma_nguoi_dung`);

--
-- Chỉ mục cho bảng `bang_don_hang_chi_tiet`
--
ALTER TABLE `bang_don_hang_chi_tiet`
  ADD PRIMARY KEY (`ma_don_hang_chi_tiet`),
  ADD KEY `FKnb8gvkvynfuwexh5lkqh83c8b` (`ma_dat_hang`),
  ADD KEY `FKgi4x8l18r2yv5t4j6wp4f6v0y` (`ma_san_pham`);

--
-- Chỉ mục cho bảng `bang_giam_gia`
--
ALTER TABLE `bang_giam_gia`
  ADD PRIMARY KEY (`ma_giam_gia`);

--
-- Chỉ mục cho bảng `bang_hinh_anh_san_pham`
--
ALTER TABLE `bang_hinh_anh_san_pham`
  ADD PRIMARY KEY (`ma_hinh_anh`),
  ADD KEY `FK9x5fxntuy2nmui0wp8wtwl0a5` (`ma_san_pham`);

--
-- Chỉ mục cho bảng `bang_nguoi_dung`
--
ALTER TABLE `bang_nguoi_dung`
  ADD PRIMARY KEY (`ma_nguoi_dung`);

--
-- Chỉ mục cho bảng `bang_nha_cung_cap`
--
ALTER TABLE `bang_nha_cung_cap`
  ADD PRIMARY KEY (`ma_nha_cung_cap`);

--
-- Chỉ mục cho bảng `bang_san_pham`
--
ALTER TABLE `bang_san_pham`
  ADD PRIMARY KEY (`ma_san_pham`),
  ADD KEY `FKi7wc8u8vrwgplly31dm259mjj` (`ma_the_loai`),
  ADD KEY `FKi9pne269dm4shettlbfnnlm50` (`giam_gia`);

--
-- Chỉ mục cho bảng `bang_san_pham_nha_cung_cap`
--
ALTER TABLE `bang_san_pham_nha_cung_cap`
  ADD KEY `FKbb8sfel3rnxha1ayp36g54gqv` (`ma_san_pham`),
  ADD KEY `FKt7a90iyy0me1boxyge6nj5xxl` (`ma_nha_cung_cap`);

--
-- Chỉ mục cho bảng `bang_thanh_toan`
--
ALTER TABLE `bang_thanh_toan`
  ADD PRIMARY KEY (`ma_thanh_toan`);

--
-- Chỉ mục cho bảng `bang_the_loai`
--
ALTER TABLE `bang_the_loai`
  ADD PRIMARY KEY (`ma_the_loai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bang_danh_gia`
--
ALTER TABLE `bang_danh_gia`
  MODIFY `ma_danh_gia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `bang_don_hang_chi_tiet`
--
ALTER TABLE `bang_don_hang_chi_tiet`
  MODIFY `ma_don_hang_chi_tiet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `bang_giam_gia`
--
ALTER TABLE `bang_giam_gia`
  MODIFY `ma_giam_gia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `bang_hinh_anh_san_pham`
--
ALTER TABLE `bang_hinh_anh_san_pham`
  MODIFY `ma_hinh_anh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT cho bảng `bang_nguoi_dung`
--
ALTER TABLE `bang_nguoi_dung`
  MODIFY `ma_nguoi_dung` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `bang_nha_cung_cap`
--
ALTER TABLE `bang_nha_cung_cap`
  MODIFY `ma_nha_cung_cap` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `bang_san_pham`
--
ALTER TABLE `bang_san_pham`
  MODIFY `ma_san_pham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT cho bảng `bang_thanh_toan`
--
ALTER TABLE `bang_thanh_toan`
  MODIFY `ma_thanh_toan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `bang_the_loai`
--
ALTER TABLE `bang_the_loai`
  MODIFY `ma_the_loai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bang_danh_gia`
--
ALTER TABLE `bang_danh_gia`
  ADD CONSTRAINT `FK3m37pivvc8abtxlpgub7np66s` FOREIGN KEY (`ma_khach_hang`) REFERENCES `bang_nguoi_dung` (`ma_nguoi_dung`),
  ADD CONSTRAINT `FKp7rp3cdbvce7gs4qo1qpp7dvt` FOREIGN KEY (`ma_san_pham`) REFERENCES `bang_san_pham` (`ma_san_pham`);

--
-- Các ràng buộc cho bảng `bang_don_hang`
--
ALTER TABLE `bang_don_hang`
  ADD CONSTRAINT `FKmsxxscy1v5w6og90j38n8ya92` FOREIGN KEY (`ma_nguoi_dung`) REFERENCES `bang_nguoi_dung` (`ma_nguoi_dung`),
  ADD CONSTRAINT `FKpxht1ntxhv32frnu9vcg1xn6i` FOREIGN KEY (`ma_thanh_toan`) REFERENCES `bang_thanh_toan` (`ma_thanh_toan`);

--
-- Các ràng buộc cho bảng `bang_don_hang_chi_tiet`
--
ALTER TABLE `bang_don_hang_chi_tiet`
  ADD CONSTRAINT `FKgi4x8l18r2yv5t4j6wp4f6v0y` FOREIGN KEY (`ma_san_pham`) REFERENCES `bang_san_pham` (`ma_san_pham`),
  ADD CONSTRAINT `FKnb8gvkvynfuwexh5lkqh83c8b` FOREIGN KEY (`ma_dat_hang`) REFERENCES `bang_don_hang` (`ma_dat_hang`);

--
-- Các ràng buộc cho bảng `bang_hinh_anh_san_pham`
--
ALTER TABLE `bang_hinh_anh_san_pham`
  ADD CONSTRAINT `FK9x5fxntuy2nmui0wp8wtwl0a5` FOREIGN KEY (`ma_san_pham`) REFERENCES `bang_san_pham` (`ma_san_pham`);

--
-- Các ràng buộc cho bảng `bang_san_pham`
--
ALTER TABLE `bang_san_pham`
  ADD CONSTRAINT `FKi7wc8u8vrwgplly31dm259mjj` FOREIGN KEY (`ma_the_loai`) REFERENCES `bang_the_loai` (`ma_the_loai`);

--
-- Các ràng buộc cho bảng `bang_san_pham_nha_cung_cap`
--
ALTER TABLE `bang_san_pham_nha_cung_cap`
  ADD CONSTRAINT `FKbb8sfel3rnxha1ayp36g54gqv` FOREIGN KEY (`ma_san_pham`) REFERENCES `bang_san_pham` (`ma_san_pham`),
  ADD CONSTRAINT `FKt7a90iyy0me1boxyge6nj5xxl` FOREIGN KEY (`ma_nha_cung_cap`) REFERENCES `bang_nha_cung_cap` (`ma_nha_cung_cap`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
