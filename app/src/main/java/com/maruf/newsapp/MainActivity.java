package com.maruf.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    LayoutInflater layoutInflater;

    HashMap<String, String> hashMap = new HashMap<>();

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //*****************************************************************************************
        //*****************************************************************************************
        listView = findViewById(R.id.listview);

        datatable();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

    }
    //*****************************************************************************************
    //*****************************************************************************************
    //*****************************************************************************************

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {

            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {

            return null;
        }

        @Override
        public long getItemId(int position) {

            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myview = layoutInflater.inflate(R.layout.item, parent, false);

            TextView cat, title, des;
            ImageView itemimage;
            LinearLayout itemlayout;
            cat = myview.findViewById(R.id.itemcat);
            itemimage = myview.findViewById(R.id.itemimage);
            title = myview.findViewById(R.id.itemtitle);
            des = myview.findViewById(R.id.itemdes);
            itemlayout=myview.findViewById(R.id.itemlayout);

            hashMap = arrayList.get(position);
            String icat, iimage_url, ititle, ides;
            icat = hashMap.get("cat");
            iimage_url = hashMap.get("image_url");
            ititle = hashMap.get("title");
            ides = hashMap.get("des");

            Picasso.get().load(iimage_url).placeholder(R.drawable.blank_image).into(itemimage);

            cat.setText(icat);

            title.setText(ititle);
            des.setText(ides);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            cat.setBackgroundColor(color);

            itemlayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    NewsDetails.TITLE=ititle;
                    NewsDetails.DESCRIPTION=ides;

                    Bitmap bitmap= ((BitmapDrawable)itemimage.getDrawable()).getBitmap();

                    NewsDetails.MY_BITMAP = bitmap;


                    startActivity(new Intent(MainActivity.this, NewsDetails.class));
                }
            });

            return myview;

        }

    }

    //*****************************************************************************************
    //*****************************************************************************************
    //*****************************************************************************************
    private void datatable() {

        hashMap = new HashMap<>();
        hashMap.put("cat", "TECH");
        hashMap.put("image_url", "https://digibanglatech.news/uploads/images/202512/image_870x_69537015ca52e.jpg ");
        hashMap.put("title", "Meta Makes Major Move, Acquires AI Startup Manas for $2B ");
        hashMap.put("des", "Social media giant Meta has made a significant stride in artificial intelligence by acquiring Singapore-based AI startup Manas, reports TechCrunch. \n" + "\n" + " \n" + "\n" + "Earlier this year, Manas gained attention with a viral demo showcasing AI agents capable of job candidate screening, travel planning, and stock market analysis. The company claimed its technology surpassed even OpenAI’s deep research capability \n" + "\n" + " \n" + "\n" + "Within weeks, Manas secured $75 million in investment at a valuation of around $500 million. Despite some criticism, the startup quickly amassed millions of users and generated $100 million in annual recurring revenue.  \n" + "\n" + " \n" + "\n" + "According to the Wall Street Journal, Meta completed the acquisition for approximately $2 billion, stating that Manas will operate independently but its AI agents will be integrated into Facebook, Instagram, and WhatsApp. Meta also announced the cessation of Chinese investment and operations in the startup. es. \n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat", "Edu");
        hashMap.put("image_url", "https://media.prothomalo.com/prothomalo-english%2F2025-09-04%2F4pq0qxrt%2FStudent.avif?rect=49%2C0%2C900%2C600&w=622&auto=format%2Ccompress&fmt=png");
        hashMap.put("title", "Junior scholarship exam for Wednesday postponed, new date announced ");
        hashMap.put("des", "The junior scholarship examination scheduled for tomorrow, Wednesday, was postponed, the examination will now be held on 5 January. \n" + "\n" + " \n" + "\n" + "The Dhaka Secondary and Higher Secondary Education Board announced the postponement today, Tuesday (30 December 2025). \n" + "\n" + " \n" + "\n" + " \n" + "\n" + "In a notification, the Dhaka Education Board said the government declared a general holiday for tomorrow, Wednesday (31 December 2025), following the death of BNP Chairperson and former Prime Minister Khaleda Zia. \n" + "\n" + " \n" + "\n" + " \n" + "\n" + "In this situation, the examination scheduled for 31 December 2025, under the ongoing Junior Scholarship Examination 2025 timetable has been postponed. The postponed examination will be held on Monday, 5 January 2026, at the scheduled time. \n" + "\n" + " \n" + "\n" + " \n" + "\n" + "Earlier, the junior scholarship examination began simultaneously across the country on Sunday. The examination started at 10:00 am and ended at 1:00 pm. \n" + "\n" + " \n" + "\n" + "On the opening day, the Bangla subject examination was held. The English examination took place on Monday, and the Mathematics examination was held today, Tuesday. \n" + "\n" + " \n" + "\n" + "Due to the death of Khaleda Zia, the Science, and Bangladesh and Global Studies examinations scheduled for Wednesday have been postponed. ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat", "Sports");
        hashMap.put("image_url", "https://media.prothomalo.com/prothomalo-english%2F2025-12-27%2Ft68cot9l%2Fprothomalo-bangla2025-12-27sh2kjb0zWhatsApp-Image-2025-12-27-at-2.06.08-PM.avif?w=622&auto=format%2Ccompress&fmt=png");
        hashMap.put("title", "BPL: Dhaka Capitals assistant coach dies after collapse before match");
        hashMap.put("des", "Dhaka Capitals’ assistant coach Mahbub Ali passed away after collapsing on the field just minutes before the start of their Bangladesh Premier League (BPL) match against Rajshahi Warriors in Sylhet on Saturday. \n" + "\n" + " \n" + "\n" + "He was taken to a hospital after the collapse where he died. \n" + "\n" + " \n" + "\n" + "The incident occurred during the warm-up session at the Sylhet International Cricket Stadium, around 20 minutes before the scheduled start. \n" + "\n" + " \n" + "\n" + "Players from both teams and coaching staff were present on the field when Mahbub Ali suddenly fell to the ground, prompting immediate concern and a brief commotion. \n" + "\n" + " \n" + "\n" + "In a short statement, Dhaka Capitals said Mahbub Ali felt unwell during training and collapsed on the field. \n" + "\n" + " \n" + "\n" + "He was given CPR at the venue before being taken to hospital. \n" + "\n" + " \n" + "\n" + "Despite the incident, the match went ahead as scheduled. \n" + "\n" + " \n" + "\n" + "Dhaka Capitals won the toss and chose to field against Rajshahi Warriors, with the team regaining focus shortly before play began. ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat", "TRENDING");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2022/04/%E0%A6%85%E0%A6%9A%E0%A6%BF%E0%A6%B0%E0%A7%87%E0%A6%87-%E0%A6%95%E0%A6%BF-%E0%A6%AA%E0%A7%83%E0%A6%A5%E0%A6%BF%E0%A6%AC%E0%A7%80-%E0%A6%86%E0%A6%95%E0%A7%8D%E0%A6%B0%E0%A6%AE%E0%A6%A3-%E0%A6%95%E0%A6%B0%E0%A6%AC%E0%A7%87-%E0%A6%8F%E0%A6%B2%E0%A6%BF%E0%A7%9F%E0%A7%87%E0%A6%A8%E0%A6%B0%E0%A6%BE.jpg");
        hashMap.put("title", "অচিরেই কি পৃথিবী আক্রমণ করবে এলিয়েনরা?");
        hashMap.put("des", "এলিয়েন নিয়ে সব চেয়ে বেশি ও ব্যাপক আকারে গবেষণা চালাচ্ছে মার্কিন মহাকাশ গবেষণা সংস্থা নাসা।\n" + "তারা এই গবেষণার সূত্রে মহাকাশে সাংকেতিক বার্তাও পাঠাচ্ছে। এই বার্তা পৃথিবী ছেড়ে মহাকাশে ছড়িয়ে পড়লে গবেষণায় নতুন তথ্য জানার চেয়ে উল্টো বিপত্তি ঘটবে বলেই মনে করছেন বিজ্ঞানীদের একাংশ।\n" + "সৌরজগতের বাইরে আর কোনো সৌরজগৎ আছে কিনা, তা নিয়ে বিজ্ঞানীদের মধ্যে কৌতূহলের অন্ত নেই। সব দেশই নিজেদের মতো করে অনুসন্ধান করছে আরেক সৌরজগতের।\n" + "\n" + "এই অনুসন্ধানের প্রধান জিজ্ঞাসা হল, এলিয়েন বলতে সত্যিই কি কিছু আছে?\n" + "বিজ্ঞানীদের আশঙ্কা, সৌরজগতের বাইরে যদি সত্যিই কোনো ভিনজগৎ থেকে থাকে, সেখানকার ভিন্ন ধাঁচের প্রাণীও তবে তারা পৃথিবী থেকে পাঠানো বার্তার সূত্র ধরে খোঁজ পেয়ে যেতে পারে পৃথিবী নামক গ্রহটির।\n" + "আর পৃথিবীর অস্তিত্ব জেনে গেলে সেটা পৃথিবীর জন্য মোটেও ভালো হবে না। কেননা, যদি এলিয়েনরা পৃথিবী আক্রমণ করে, তবে সেটা একটা ভয়ানক ব্য়াপার হবে।\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat", "Economy");
        hashMap.put("image_url", "https://media.prothomalo.com/prothomalo-english%2F2025-12-29%2Fii9g9ac1%2Fprothomalo-bangla2023-12b0007dd4-a463-4cee-949b-f282c5076c45Businessthumbnail.avif?rect=1%2C0%2C621%2C414&w=622&auto=format%2Ccompress&fmt=jpg");
        hashMap.put("title", "No pledge of loans from India, China, Russia, Japan in 5 months ");
        hashMap.put("des", "In the first five months of the current fiscal year (July–November), no major friendly countries pledged any new loans. \n" + "\n" + " \n" + "\n" + "The countries are: India, China, Russia, and Japan. Although these four countries did not make new pledges, they disbursed funds from previously taken loans. \n" + "\n" + " \n" + "\n" + "In addition, the Asian Infrastructure Investment Bank (AIIB) also did not pledge any loans during the past five months. \n" + "\n" + " \n" + "\n" + "This came up in the updated report on the foreign loan situation for the July–November period, published by the Economic Relations Division (ERD) on Monday. \n" + "\n" + " \n" + "\n" + "According to the ERD report, in the first five months of the 2025-26 fiscal year (July–November), donor agencies and countries disbursed a total of US$1.95 billion. \n" + "\n" + " \n" + "\n" + "Meanwhile, $1.89 billion was spent on paying interest and principal on previously taken loans. This means that over the past five months, the government has had to repay almost the same amount as the foreign loans it received. \n" + "\n" + " \n" + "\n" + "ERD sources said that Bangladesh received a total of $1.22 billion in loan pledges during the first five months of the current fiscal year. No pledges were received in November. Of the total pledges, $580 million came from the Asian Development Bank (ADB), while the World Bank pledged nearly $20 million. Other donor agencies and countries have committed to providing $625 million over the remaining four months. \n" + "\n" + " \n" + "\n" + "In the first four months of the previous fiscal year, $520 million in loan pledges was received. \n" + "\n" + " \n" + "\n" + "In the first five months of the fiscal year (July–November), Russia disbursed the highest amount of loans, providing $550 million. It was followed by the World Bank, which disbursed $430 million, and the ADB, which provided $335 million. ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat", "TIPS");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2021/04/%E0%A6%AC%E0%A6%BE%E0%A7%9C%E0%A6%BF%E0%A7%9F%E0%A7%87-%E0%A6%A8%E0%A6%BF%E0%A6%A8-%E0%A6%B8%E0%A7%8D%E0%A6%AE%E0%A6%BE%E0%A6%B0%E0%A7%8D%E0%A6%9F%E0%A6%AB%E0%A7%8B%E0%A6%A8%E0%A7%87%E0%A6%B0-%E0%A6%AC%E0%A7%8D%E0%A6%AF%E0%A6%BE%E0%A6%9F%E0%A6%BE%E0%A6%B0%E0%A6%BF%E0%A6%B0-%E0%A6%86%E0%A7%9F%E0%A7%81.jpg");
        hashMap.put("title", "সারাদিন ব্যবহারেও ফুরাবে না ফোনের ব্যাটারি, মানলে এই নিয়ম");
        hashMap.put("des", "অনেকেরই অভিযোগ স্মার্টফোনের আয়ু দ্রুত ফুরায়। এর কারণ অনেক। আজকাল প্রায় সব স্মার্টফোনেই একটি লিথিয়াম আয়ন ব্যাটারি ব্যবহার হয়। তুলনামূলক হালকা এই ব্যাটারিগুলো ব্যবহার করার কারণে স্মার্টফোন আরও পাতলা হয়েছে।ফোন দীর্ঘদিন ধরে ব্যবহার করতে থাকলে ক্রমশ ব্যাটারি ব্যাক আপ কমতে শুরু করে। কারণ প্রত্যেকবার আপনার ফোন চার্জ করলে ধীরে ধীরে ব্যাটারির আয়ু ও ক্ষমতা কমতে থাকে। তবে দীর্ঘদিন ধরে ফোনে লম্বা ব্যাটারি ব্যাক আপ পাবেন কীভাবে? জানুন এই প্রতিবেদনে।\n" + "০% অথবা ১০০% চার্জ দেবেন না\n" + "অনেকেই নিজের ফোন ১০০ শতাংশ পর্যন্ত চার্জ করেন। কিন্তু এতে ফোনের ব্যাটারির ক্ষমতা কমতে শুরু করে। তাই ফোনের ব্যাটারি কখনই সম্পূর্ণ চার্জ করবেন না। চেষ্টা করুন ৮০-৯০ শতাংশের মধ্যে চার্জিং বন্ধ করে দিতে। আপনি যদি ৬০ শতাংশ চার্জিংয়ের পরে চার্জিং বন্ধ করতে পারেন তবে আপনার ফোনের ব্যাটারি অনেক দিন লম্বা ব্যাক আপ দেবে। এছাড়াও ফোনের ব্যাটারি কখনই ০ শতাংশ পর্যন্ত ডিসচার্জ করবেন না। চেষ্টা করুন ৩০ শতাংশ চার্জের নিচে গেলে ফের চার্জ শুরু করে দিতে।\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat", "TECH");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2022/04/%E0%A7%AA%E0%A7%AA-%E0%A6%AC%E0%A6%BF%E0%A6%B2%E0%A6%BF%E0%A7%9F%E0%A6%A8-%E0%A6%A1%E0%A6%B2%E0%A6%BE%E0%A6%B0%E0%A7%87-%E0%A6%9F%E0%A7%81%E0%A6%87%E0%A6%9F%E0%A6%BE%E0%A6%B0%E0%A7%87%E0%A6%B0-%E0%A6%AE%E0%A6%BE%E0%A6%B2%E0%A6%BF%E0%A6%95-%E0%A6%B9%E0%A6%9A%E0%A7%8D%E0%A6%9B%E0%A7%87%E0%A6%A8-%E0%A6%87%E0%A6%B2%E0%A7%8B%E0%A6%A8-%E0%A6%AE%E0%A6%BE%E0%A6%B8%E0%A7%8D%E0%A6%95.jpg\n");
        hashMap.put("title", "৪৪ বিলিয়ন ডলারে টুইটারের মালিক হচ্ছেন ইলোন মাস্ক");
        hashMap.put("des", "নগদে ৪ হাজার ৪০০ কোটি মার্কিন ডলার পরিশোধ করে মাইক্রো ব্লগিং সাইট টুইটার কিনে নিচ্ছেন টেসলা ও স্পেস এক্সের প্রতিষ্ঠাতা নির্বাহী (সিইও) ইলোন মাস্ক। টুইটারের পরিচালনা পর্ষদও তার এ অধিগ্রহণ প্রস্তাব গ্রহণ করেছে। স্থানীয় সময় সোমবার এ ঘোষণা দেয়া হয়। খবর রয়টার্স।\n" + "প্রতিবেদনে বলা হয়, ইলোন মাস্ক তার ৪৪ বিলিয়নের এ প্রস্তাবকে সেরা ও চূড়ান্ত বলে মন্তব্য করেছেন। অপেক্ষা কেবল টুইটারের পরিচালনা পর্ষদের। তাদের অনুমোদন পেলেই লেনদেন চূড়ান্ত হয়ে যাবে।\n" + "খবরে আরো বলা হয়, বিক্রি হলে টুইটারের প্রতিটি শেয়ারের সম্ভাব্য দাম হতে পারে ৫৪ দশমিক ২০ ডলার। স্থানীয় সময় সোমবার রাতে সাইটটি বিক্রি সংক্রান্ত আনুষ্ঠানিক ঘোষণা আসতে পারে। তার আগেই নিউইয়র্ক স্টক এক্সচেঞ্জে দিনের শুরুতে টুইটারের শেয়ারের দর সাড়ে ৪ শতাংশ বেড়ে ৫১ দশমিক ১৫ ডলারে পৌঁছেছে।\n" + "ফোর্বসের হিসাব অনুসারে ৫০ বছর বয়সী মাস্কের বর্তমান সম্পদের পরিমাণ ২১৯ বিলিয়ন ডলার। ধারণা করা হচ্ছে নিজের অর্থায়নেই টুইটার কিনে নেবেন ইলোন মাস্ক। এতে টেসলার কোনো অংশগ্রহণ থাকবে না। অবশ্য মাস্ক বা টুইটার থেকে এ ব্যাপারে এখনো কোনো মন্তব্য আসেনি।\n" + "\n" + "\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat", "TECH");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2022/05/nothing-lead-20220507134631.jpg");
        hashMap.put("title", "আইফোনের সঙ্গে টেক্কা দেবে নাথিং ফোন ১, দাম হবে কত");
        hashMap.put("des", "জল্পনা-কল্পনার অবসান ঘটিয়ে বাজারে আস্তে যাচ্ছে লন্ডন ভিত্তিক প্রযুক্তি কোম্পানি নাথিং টেকনোলজি লিমিটেডের নতুন ফোন ‘নাথিং ফোন ১’। এই বিষয়টি নিশ্চিত করা হলেও ফোনটির ফিচার বা দাম নিয়ে সুস্পষ্ট ইঙ্গিত দেয়নি কোম্পানিটি।\n" + "সম্প্রতি অনলাইনে দীর্ঘ ইভেন্টের আয়োজন করে নাথিং। যেখানে এই ফোনটির লঞ্চের বিষয়ে বলা হয়। সেই অনুষ্ঠানে কয়েকবার জানানো হয় অ্যাপলের সঙ্গে প্রতিযোগিতা করবে নাথিং ফোন ১। অর্থাৎ আইফোনের সঙ্গে টেক্কা দেবে ফোনটি। এমনটিই নির্মাতা প্রতিষ্ঠানের দাবি।\n" + "এ বছরের মাঝামাঝি সময়ে নাথিং ফোন ১ লঞ্চ হওয়ার বিষয়টি নিশ্চিত করেছে নাথিং এর প্রতিষ্ঠাতা কার্ল পে। ফ্লিপকার্টের মাধ্যমে ভারতের বাজারে ফোনটি বিক্রি শুরু করবে তারা। ইতোমধ্যে ফোনটির বেশ কিছু ফিচার সম্পর্কে তথ্য প্রকাশ্যে এসেছে।\n" + "\n" + "টিপস্টার থেকে যে স্পেসিফিকেশন জানা গিয়েছে তা থেকে ধারণা করা হচ্ছে সম্ভবত মিড রেঞ্জের ফোন হবে নাথিং ফোন ১। আইফোনের স্পেসিফিকেশনের সঙ্গে টেক্কা দিলেও, সেই তুলনায় দাম রাখা হবে অনেক কম। এমনটাই অনুমান করা হচ্ছে।\n" + "\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat", "GAME");
        hashMap.put("image_url", "https://i0.wp.com/techzoom.tv/wp-content/uploads/2021/05/%E0%A6%AB%E0%A7%8D%E0%A6%B0%E0%A6%BF-%E0%A6%AB%E0%A6%BE%E0%A7%9F%E0%A6%BE%E0%A6%B0-%E0%A6%93-%E0%A6%AA%E0%A6%BE%E0%A6%AC%E0%A6%9C%E0%A6%BF.jpg");
        hashMap.put("title", "মাদকের চেয়ে কম নয় পাবজি");
        hashMap.put("des", "আধুনিক বিশ্বের সাথে খাপ খাওয়াতে হলে ইন্টারনেট কিংবা স্মার্টফোনকে বাদ দেওয়ার কোন উপায় নেই। কিন্তু বর্তমান তরুণ প্রজন্মকে স্মার্টফোন কতটা সুফল এনে দিচ্ছে সেটা ভাবার সময় এসেছে। মাস তিনেক আগে আমি গ্রামের বাড়িতে গিয়েছিলাম। বিকেলবেলা বন্ধুদের সাথে হাঁটতে বেরিয়েছি। হাঁটতে হাঁটতে রাস্তার পাশে কিছু অনূর্ধ্ব আঠারো বয়সের ছেলে আমার চোখে পড়ল। ওদের মধ্য থেকে শব্দ আসছিল ‘মামা, মার মার। এবার ধর’ আমি শব্দটা শুনে থেমে গেলাম এবং আমার সাথে থাকা বন্ধুকে জিজ্ঞেস করলাম যে, শব্দটা ওদের কাছ থেকে আসলো না? ও বলল, ‘হ্যাঁ, ওখান থেকেই এসেছে, ওরা পাবজি খেলছে।’\n" + "আমি কিছুক্ষণ অবাক হয়ে তাকিয়ে ছিলাম। গ্রামের এই পাবজি খেলার সংখ্যাটা ষোল কিংবা আঠারো অনূর্ধ্ব বেশিরভাগই। এদের অনেকের পরিবারের আর্থিক অবস্থা খুব শোচনীয়। কারো পরিবারে খাবারই ঠিক মতো জুটে না। অধিকাংশ ছেলেরা অনলাইন ক্লাসের দোহাই দিয়ে স্মার্টফোন কিনেছে। কিংবা কেউ কেউ পরিবারের চোখ ফাঁকি দিয়ে স্মার্টফোন কিনেছে। কিন্তু সবার আসল উদ্দেশ্য পাবজি খেলা। আজ থেকে ঠিক দশ বছর আগের কথা যদি চিন্তা করি তবে দেখা যাবে তখন স্মার্টফোন এতটা সহজলভ্য ছিল না আর অনলাইনভিত্তিক গেমসও তেমন ছিল না। কিন্তু এখন স্মার্টফোন খুব সহজলভ্য। এমন অবস্থা হয়েছে, সদ্য জন্ম নেওয়া বাচ্চার কান্নাও বন্ধ হচ্ছে মোবাইল দেখে।\n" + "\n");
        arrayList.add(hashMap);

    }

}