package com.example.ordering.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apporder.R;
import com.example.apporder.common.SharedPreference;
import com.example.apporder.models.ItemModel;

public class ItemActivity extends AppCompatActivity {
    TextView name;
    TextView price;
    TextView credit;
    ImageView item_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.item);
        name=findViewById(R.id.name);
        price=findViewById(R.id.price);
        credit=findViewById(R.id.credit);
        item_img=findViewById(R.id.item_img);
        Intent intent = getIntent();
        int imageItem = intent.getIntExtra("ImageItem", 0);
        String nameItem = intent.getStringExtra("NameItem");
        String priceItem = intent.getStringExtra("PriceItem");
        name.setText(nameItem); price.setText(priceItem);
        item_img.setImageResource(imageItem);
        if (nameItem.equals("Trà Sữa Trân Châu Đường Đen")) {String cre="Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..";credit.setText(cre);}
        else if (nameItem.equals("Trà Sữa Thái Đỏ")) {String cre="Trà Thái đỏ hay còn có tên gọi khác là trà sữa Thái đỏ, trà đá Thái Lan hoặc trà Thái, đây là loại thức uống phổ biến của người dân Thái Lan. Trà khi pha ra có nước mà hổ phách vô cùng đẹp mắt và có hương thơm nhẹ, rất thích hợp làm nguyên liệu để pha trà sữa.";credit.setText(cre);}
        else if (nameItem.equals("Trà Sữa Thái Xanh")) {String cre="Trà sữa thái xanh là một món uống đang được yêu thích nhất của giới trẻ hiện nay bởi hương thơm của trà thái thanh mát, kết hợp với các loại thạch rau câu dẻo. Trà thái có mùi thơm thanh dịu sự kết hợp của lá trà, bột trà hòa quyện trong đó là vị thơm của các loại hoa mộc có tác dụng giải nhiệt, bổ sung chất dinh dưỡng cho sức khỏe.";credit.setText(cre);}
        else if (nameItem.equals("Trà Sữa Ô Long Kem Trứng")) {String cre="Trà sữa kem trứng nướng có lớp kem trứng màu vàng đẹp mắt, khi thưởng thức sẽ cảm nhận được vị béo thơm của kem trứng, hòa quyện cùng vị trà sữa pha từ hồng trà nướng và trà gạo rất đặc biệt và hấp dẫn.";credit.setText(cre);}
        else if (nameItem.equals("Trà Sữa Matcha")) {String cre="Trà sữa sử dụng bột matcha và lục trà (trà xanh) để tạo nên hương vị trà sữa thanh nhẹ, thích hợp với người dễ bị say trà. Với công dụng tuyệt vời của matcha, ngoài là thức uống giải khát thì trà sữa matcha cung cấp cho cơ thể một lượng vitamin A và vitamin C vừa đủ, giúp cơ thể giải tỏa căng thẳng và mệt mỏi.";credit.setText(cre);}
        else if (nameItem.equals("Trà Sữa Truyền Thống")) {String cre="Trà Sữa Truyền Thống với đậm vị trà hòa kết hợp cùng vị béo thơm của sữa mang đến một thức uống thơm ngon được nhiều người ưa thích.";credit.setText(cre);}
        else if (nameItem.equals("Trà Chanh Ổi")) {String cre="Cùng đánh thức vị giác với hương trà nồng ấm, thơm dịu của ổi và thanh mát của chanh dây với món đồ uống hấp dẫn – Trà chanh dây ổi hồng.";credit.setText(cre);}
        else if (nameItem.equals("Trà Xoài")) {String cre="Xoài là loại trái cây không chỉ thơm ngon mà còn nhiều dưỡng chất. Trà xoài cũng là loại thức uống giải nhiệt thích hợp cho những ngày nắng nóng";credit.setText(cre);}
        else if (nameItem.equals("Trà Chanh Dây")) {String cre="Trà chanh dây là một trong các loai nước uống mùa hè không thể bỏ qua. Trà chanh dây mát lạnh sẽ là món đồ uống mà những người mê đồ chua yêu thích. Vị chua chua thanh mát của chanh dây hòa quyện với vị chát của trà sẽ làm ra một món đồ uống không ai có thể chối từ.";credit.setText(cre);}
        else if (nameItem.equals("Trà Bưởi")) {String cre=" Hương thơm ngọt ngào của hoa bưởi kết hợp cùng tuyệt phẩm trà Thái Nguyên tạo nên một hương vị trà độc đáo. ";credit.setText(cre);}
        else if (nameItem.equals("Trà Đào")) {String cre="Trà đào là một thức uống mang hương vị ngọt ngào, tươi mới, là sự kết hợp của những lát đào chua chua ngọt ngọt cùng hương đậm đà của trà.";credit.setText(cre);}
        else if (nameItem.equals("Trà Dâu")) {String cre="Sản phẩm cho ra phần cốt trà với màu nước đỏ tươi đẹp mắt, hương thơm tươi mát ấn tượng, vị chua thanh, không chứa đường nên dễ kết hợp với các nguyên liệu khác.";credit.setText(cre);}
        else if (nameItem.equals("Trà Vải")) {String cre="Trà vải hoa hồng là sự kết hợp hoàn hảo của trà xanh hoa nhài Đài Loan đậm vị, cùng mứt vải hoa hồng dịu dàng thơm ngọt tạo nên thứ thức uống quyến rũ đầy tươi mát. Topping vải ngâm chua ngọt hấp dẫn góp phần hoàn thiện hương vị tuyệt hảo của món trà. Thưởng thức một cốc trà vải hoa hồng mát lạnh chắc chắn sẽ là một sự lựa chọn hoàn hảo, giúp xua tan đi cái nóng oi ả của tiết trời mùa hè.";credit.setText(cre);}
        else if (nameItem.equals("Trà Dưa Hấu")) {String cre="Trà dưa hấu với thành phần chính là nước ép nguyên chất từ dưa hấu, kèm theo đó là một số nguyên liệu như trà, syrup, nước đường và đá viên. Sự kết hợp này không những giúp thanh nhiệt, sảng khoái mà còn cung cấp nhiều dưỡng chất tốt cho sức khỏe và làm đẹp da. ";credit.setText(cre);}
        else if (nameItem.equals("Trà Thanh Long")) {String cre="Nước cốt trà hòa quyện cùng thanh long có mùi thơm đặc trưng, ngọt thanh, ngon hơn hẳn thanh long ở các vùng khác. Sản phẩm có màu tím đỏ tự nhiên của thanh long đỏ, vị ngọt hơi chát. Hương thơm và màu sắc quyễn rũ, vị ngon khó quên.";credit.setText(cre);}
        else if (nameItem.equals("Trà Trái Cây Nhiệt Đới")) {String cre="Trà trái cây nhiệt đới hay còn gọi là trà hoa quả - một loại thức uống giải khát đặc biệt vào các mùa. Đây là thức uống được rất nhiều bạn trẻ ưa chuộng hiện nay. Trà trái cây là sự kết hợp từ lá trà và cùng với trái cây nhiệt đới như xoài, đào, vải, chanh dây,...";credit.setText(cre);}
        else if (nameItem.equals("Cà Phê Đen Đá")) {String cre="Cà phê đen là một trong những loại thức uống quen thuộc của người Việt. Được làm từ cà phê nguyên chất 100%, cà phê đen mang hương vị đậm đà, mạnh mẽ, giúp bạn tỉnh táo và tái tạo năng lượng.";credit.setText(cre);}
        else if (nameItem.equals("Cà Phê Sữa Đá")) {String cre="Cà phê sữa đá là một loại thức uống thông dụng ở Việt Nam. Cà phê sữa đá truyền thống được làm từ cà phê nguyên chất đựng trong phin với sữa đặc có đường và bỏ đá vào trong một cái ly bằng thủy tinh rồi thưởng thức.";credit.setText(cre);}
        else if (nameItem.equals("Bạc Xĩu")) {String cre="Bạc xỉu là một loại đồ uống được làm từ cà phê có pha sữa nhưng phần sữa sẽ nhiều hơn so với phần cà phê.";credit.setText(cre);}
        else if (nameItem.equals("Coffee Jelly")) {String cre="Thêm một chút thạch jelly đơn giản sẽ làm cho ly cà phê sữa đá quen thuộc trở nên hấp dẫn hơn";credit.setText(cre);}
        else if (nameItem.equals("Frothy Whipped Coffee")) {String cre="Mùi hương của một tách cà phê Espresso cùng kem ngọt đánh bông và đường. Hương thơm cà phê ngọt béo pha chút đắng";credit.setText(cre);}
        else if (nameItem.equals("Cà Phê Trứng")) {String cre="Cà phê trứng là một loại thức uống có nguồn gốc từ Việt Nam được làm từ cà phê (cà phê vối) với trứng gà (có nhỏ thêm mật ong) và sữa đặc có đường.";credit.setText(cre);}
        else if (nameItem.equals("Mango - Berry Smoothie")) {String cre="Với thành phần gồm có Mango kết hợp cùng vị Berry tươi được nghiền đặc, kết hợp với đường, nước, sữa và các hương vị tự nhiên tạo nên thức uống đậm vị và thơm ngon";credit.setText(cre);}
        else if (nameItem.equals("Kiwi Smoothie")) {String cre="Sinh tố Kiwi với thành phần gồm: quả Kiwi tươi được nghiền đặc, kết hợp với đường, nước và các hương vị tự nhiên, tạo thành một hỗn hợp mứt sệt trái cây – giúp cho sản phẩm đồ uống của bạn thơm ngon và chất lượng hơn.";credit.setText(cre);}
        else if (nameItem.equals("Watermelon Smoothie")) {String cre="Sinh tố dưa hấu có màu hồng đỏ đẹp mắt. Hương vị ngọt tự nhiên và mát lạnh. Sinh tố dưa hấu không bị tách lớp, đá được xay nhuyễn mịn hoàn toàn.";credit.setText(cre);}
        else if (nameItem.equals("Mango - Banana Smoothie")) {String cre="Sinh tố xoài chuối là sự lựa chọn giải nhiệt ngày hè đầy thơm ngon. Sự kết hợp từ 2 loại trái cây nhiệt đới giàu vitamin C và chất chống oxy hóa giúp làn da tươi trẻ đầy sức sống.";credit.setText(cre);}
        else if (nameItem.equals("Light Oreo Smoothie")) {String cre="Sinh tố Oreo nhẹ này, có vị giống như một ly Sữa lắc Oreo béo ngậy, sẽ trở thành món ăn nhẹ yêu thích của bạn mà không cảm thấy tội lỗi. Nếu bạn yêu thích điều này, bạn cũng sẽ yêu thích Oreo Frosting này.";credit.setText(cre);}
        else if (nameItem.equals("Green Tea Matcha Smoothie")) {String cre="Trong các món ngon từ matcha không thể bỏ qua sinh tố matcha thơm ngon, lạ miệng này đó. Món sinh tố này rất thích hợp cho các bạn muốn giảm cân, giữ dáng";credit.setText(cre);}
        else if (nameItem.equals("Avocado - Banana Smoothie")) {String cre="Một ly sinh tố Bơ Chuối thơm mát sẽ là cứu tinh cho một ngày hè nóng nực đó. Sinh tố bơ chuối không chỉ ngon mà còn tốt cho sức khỏe và có thể giúp cánh phụ nữ giảm cân hiệu quả.";credit.setText(cre);}
        else if (nameItem.equals("Rainbow Smoothie")) {String cre="Sinh tố cầu vồng này sẽ có tổng cộng bảy lớp: tím, xanh dương, đỏ, đỏ tươi, xanh lá cây, vàng và cam. Đặt các chùm trái cây vào các túi cấp đông riêng sau khi đã chia hết. Lớp màu tím: kết hợp nửa quả chuối và quả việt quất.";credit.setText(cre);}
        else if (nameItem.equals("Creamy Peach Smoothie")) {String cre="Sinh tố đào thơm ngon béo ngậy được làm từ 5 nguyên liệu đơn giản cho bữa sáng hoặc bữa ăn nhẹ sảng khoái, no bụng! Công thức sinh tố đào dễ dàng này được tăng cường protein từ sữa chua Hy Lạp và có vị ngọt hoàn hảo từ những quả đào và quả mọng chín. Thưởng thức nguyên trạng hoặc thêm các chất tăng cường dinh dưỡng yêu thích của bạn!";credit.setText(cre);}
        else if (nameItem.equals("Bánh Rán")) {String cre="Bánh rán là một loại bánh có vỏ ngoài mềm mịn, khi ăn lại rất xốp và ngọt dịu. Bánh có nhân socola béo ngậy, nhân đậu đỏ thơm ngon,..";credit.setText(cre);}
        else if (nameItem.equals("French Opera Cake")) {String cre="Opera cake là một loại bánh ngọt nổi tiếng của Pháp. Opera cake được ví von như một bản giao hưởng đầy ngọt ngào quyến rũ với vị béo ngậy của kem bơ quyện cùng vị chocolate đặc trưng, kết hợp với mùi cafe nồng thắm. Quả là không gì có thể \"ăn rơ\" đến vậy.";credit.setText(cre);}
        else if (nameItem.equals("Bánh Mì Bơ Tỏi")) {String cre="Bánh mì phô mai bơ tỏi là sự kết hợp của các nguyên liệu từ phô mai dạng kem, bên ngoài được phủ một lớp sốt bơ tỏi. Sau khi nướng, mùi hương của lá thơm đi kèm với lớp bơ tỏi phủ lên trên mặt  khiến bánh mì phô mai bơ tỏi càng bắt mắt và mùi vị không thể nào lẫn vào đâu được.";credit.setText(cre);}
        else if (nameItem.equals("Panna Cotta Xoài")) {String cre="Panna Cotta Xoài có vị thơm nhẹ, không bị rỗ, có vị béo ngọt tự nhiên. Bánh có độ mịn màng và mềm dẻo đặc trưng. Khi ăn vào bánh tan đều trong miệng.";}
        else if (nameItem.equals("Bánh Sừng Trâu")) {String cre="Bánh sừng trâu bơ có hương vị thơm ngon, chất lượng cao nhờ vào các nguyên liệu tốt nhất và bí quyết lâu đời của các nghệ nhân Pháp của hãng Delifrance. Bánh mềm xốp, ngon, thơm mùi bơ Pháp kích thích vị giác, dễ ăn, phù hợp với cả trẻ em và người lớn. Đây là một lựa chọn thích hợp cho bữa sáng đầy đủ dinh dưỡng của gia đình";credit.setText(cre);}
        else if (nameItem.equals("Bánh Dâu")) {String cre="Với lớp bánh mềm ngọt, kết hợp với kem và dâu tây. Vị ngọt của bánh bông lan, cộng thêm vị hơi chua thanh nhẹ của dâu tây tươi. Chắc chắn làm hài lòng bất cứ vị thực khách khó tính nào.";credit.setText(cre);}
        else if (nameItem.equals("Bánh Flan")) {String cre="Chất bánh mềm mịn, thơm mát và mang hương vị đặc trưng của caramel. Một món ăn được yêu thích như này mà cách làm lại vô cùng đơn giản.";credit.setText(cre);}
        else if (nameItem.equals("Bánh Mì Hoa Cúc")) {String cre="Bánh mì hoa cúc hay Brioche là một loại bánh mì có nguồn gốc từ Pháp. Với thành phần giàu bơ và trứng, bánh mì hoa cúc có một lớp vỏ mềm, ẩm và vàng sẫm. Khi nướng lên, bánh luôn có thớ mềm và xốp, hương vị vô cùng tuyệt vời.";credit.setText(cre);}

    }

}
