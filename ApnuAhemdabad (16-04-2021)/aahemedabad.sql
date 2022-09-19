-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2021 at 03:27 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aahemedabad`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_master`
--

CREATE TABLE `admin_master` (
  `Admin_id` int(11) NOT NULL,
  `Admin_name` varchar(45) DEFAULT NULL,
  `Admin_email` varchar(25) DEFAULT NULL,
  `Admin_password` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_master`
--

INSERT INTO `admin_master` (`Admin_id`, `Admin_name`, `Admin_email`, `Admin_password`) VALUES
(1, 'Sakshi', 'sakshi.patwari03@gmail.co', 'Sakshi@2003'),
(2, 'Dhara', 'dharathakkar23@gmail.com', 'Dhara23@22'),
(7, 'Shruti', 'shrutirathod11@gmail.com', 'Shruti@1121');

-- --------------------------------------------------------

--
-- Table structure for table `event_master`
--

CREATE TABLE `event_master` (
  `Event_id` int(11) NOT NULL,
  `Event_name` varchar(50) NOT NULL,
  `Event_location` varchar(40) DEFAULT NULL,
  `Event_details` varchar(300) DEFAULT NULL,
  `Event_photo_path` varchar(200) DEFAULT NULL,
  `Event_type_id` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `event_master`
--

INSERT INTO `event_master` (`Event_id`, `Event_name`, `Event_location`, `Event_details`, `Event_photo_path`, `Event_type_id`) VALUES
(1, 'Music concer', 'Motera Stadium ', 'BTS first concert in India. This is the biggest event in Indian BTS ARMY.', 'BTS concert.jpg', '1'),
(2, 'Music concer', 'Motera Stadium ', 'BTS first concert in India. This is the biggest event in Indian BTS ARMY.', 'BTS concert.jpg', '1'),
(3, 'Food Festival', 'GMDC Road', 'There are different types of food from India. So many stalls of Gujrati, Rajsthani, Bangali, Malyalam and so on', 'food.jpg', '2'),
(4, 'Natak', 'Tagor hall', 'Gujrati Natak - A family bau fantastic che. \r\ncast:- pratap Saidev, Vandana Vithalaani, Nayan Shukla, Disha Chawla, Ketan Sagar, Hetal Dedhia, Isha Pathak, Kailash Vyas and Sanjay Garodia\r\ncomedy, emotional  Gujrati Natak', 'natak1.jpg', '3'),
(5, 'Indie Theatre Festival 3.0 (Reboot)', 'prayogshala ashram road', 'A month long theatre festival, where 4 different dramas will be showcased and celebrated with the people of Ahmedabad.', 'indie3.0.jpg', '4'),
(6, 'NAKSHATRA EXHIBITION', 'Seema hall prahlad nagar Anand nagar jod', 'NAKSHATRA WEDDING AND LIFE STYLE EXHIBITION OF DESIGNER GARMENTS,JEWELLERY,SAREES,DOHAR,BEDSHEET,KIDS WEAR,WESTERN,LEHNGA,CHOLIS,FOOT WEAR,DECOR ITEM,HANDICRAFT,KITCHEN WEAR AND MANY MORE', 'nakshtra.jpg', '5'),
(7, 'Standup comedy', 'Pandit dindayal hall', 'Manan Desai. Ojas Rawal, Kamlesh Darji, Smit Pandya, Chirayu Mistry, Shefali Pandey Standup comedy by these famous comedians. ', 'standupcomedy.jpg', '6');

-- --------------------------------------------------------

--
-- Table structure for table `event_type`
--

CREATE TABLE `event_type` (
  `Event_type_id` int(11) NOT NULL,
  `Event_type_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `event_type`
--

INSERT INTO `event_type` (`Event_type_id`, `Event_type_name`) VALUES
(1, 'Music concert'),
(2, 'Music concert'),
(3, 'food festival'),
(4, 'Natak'),
(5, 'Indie Theatre Festival 3.0 (Reboot)'),
(6, 'Indie Theatre Festival 3.0 (Reboot)'),
(7, 'Standup comedy');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `Feedback_id` int(11) NOT NULL,
  `User_id` varchar(15) NOT NULL,
  `Feedback_details` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`Feedback_id`, `User_id`, `Feedback_details`) VALUES
(1, '1', 'it is very usefull'),
(2, '2', 'very good application'),
(3, '1', 'good work'),
(4, '3', 'good work'),
(5, '5', 'good application to know about ahmedabad and herit'),
(6, '10', ''),
(7, '10', ''),
(8, '10', ''),
(9, '10', ''),
(10, '10', ''),
(11, '10', ''),
(12, '10', 'test'),
(13, '10', 'test'),
(14, '10', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `news_master`
--

CREATE TABLE `news_master` (
  `News_id` int(11) NOT NULL,
  `news_title` varchar(80) NOT NULL,
  `News_details` varchar(500) NOT NULL,
  `News_photo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `news_master`
--

INSERT INTO `news_master` (`News_id`, `news_title`, `News_details`, `News_photo`) VALUES
(2, 'crime', 'Murder attempted', 'crime.jpg'),
(4, 'Entertainment news', 'BTSJimin, who fans would love to see playing the part of Priced Eric in The Little Mermaid, is not formally an actor. Jimin is yet to appear in a feature film or television series. In any case, this singer does have his own IMDb page and has appeared in over 40 BTS music videos. The music videos for Stay Gold, Boy With Luv, and Make It Right are labelled as "video shorts." Run BTS, a video series featuring each of the K-pop stars, features this singer as himself. These actors competed in a var', 'bTS.jpeg'),
(6, 'LIC employees protest in Ludhiana against insurance sector''s FDI limit hike', 'LIC employees staged a protest in Ludhiana against the government''s decision to raise the Foreign direct investment (FDI) limit in the insurance sector to 74 per cent and to bring an IPO of the LIC', 'LICProtest.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

CREATE TABLE `place` (
  `Place_id` int(11) NOT NULL,
  `Category_id` varchar(10) NOT NULL,
  `Place_title` varchar(200) NOT NULL,
  `Place_details` text NOT NULL,
  `Place_img_path` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `place`
--

INSERT INTO `place` (`Place_id`, `Category_id`, `Place_title`, `Place_details`, `Place_img_path`) VALUES
(1, '1', 'Manek Burj', 'Manek Burj is the foundation bastion of Bhadra Fort in the old city of Ahmedabad, Gujarat, India. Manek Burj is named after the legendary 15th century Hindu saint, Maneknath, who intervened to help Ahmed Shah I build Bhadra Fort in 1411. Manek Burj was the original bastion of Ahmedabad. It was built around the foundation stone of the city, laid by Ahmed Shah I on 26 February 1411. The bastion is 53 feet high on the outside. It once contained a roofed stepwell with a circumference of 77 feet, the Manek Kuva. The well was filled and sealed in 1866 after the Sabarmati river changed its course, causing the Manek Kuva to run dry. ', 'manekburj.jpg'),
(2, '1', 'laldarwaja', 'Historic Lal Darwaja part of the Old City is home to the 1573 Sidi Saiyyed Mosque famed for its stone latticework windows with geometric and tree-shaped designs. A lively wide promenade runs beside the Sabarmati River with many small temples nearby.', 'lal_darwaza_in_ahmedabad_featured.jpg'),
(3, '1', 'Teendarwaja', 'Teen Darwaza is a historical gateway on the east of Bhadra Fort, Ahmedabad, India. Completed in 1415, it is associated with historical as well as legendary events. ', 'teen-darwaza-ahmedabad-tourism-entry-fee-timings-holidays-reviews-header.jpg'),
(4, '1', 'Premabhai gate / Prem Darwaja', 'Prem Darwaja also known as Premabhai Gate. It was built by Ashlar Masonry in 1864 and it is situated on the north-east of the old citadel. It is also one of the known and oldest citadel which is 16 feet broad.', 'prem-darwaja.jpeg'),
(5, '1', 'DariaPur Darwaja', 'Dariapur Darwaja is situated in the north side of the Ahmedabad. It was built of Ashlars Masonry in the 16th century A.D. The doors of iron-plated timber, the gateway of three stone arches the largest 22 feet high with a roofed platform', 'dariapur.jpg'),
(6, '1', 'Kalupur Darwaja', 'Kalupur Darwaja was used for the brought Food into the city. Mohammad Begada who built the Kalupur Darwaja in the 15th century. Made of iron-plated timber, Kalupur Darwaja is 27 feet high and has slits through which guns could be fired from inside. Though the fort wall enclosing the old Ahmedabad city is mostly in ruins or removed in most places, the entry gates still stand.', 'Kalupur_Darwaja.jpg'),
(7, '1', 'Sarangpur Darwaja', 'Sarangpur Darwaja is situated near Ahmedabad Railway Station. People used Sarangpur Darwaja for enter and exit from the city.', 'sarangpur.jpg'),
(8, '1', 'Panch kuwa darwaja', 'Panchkuwa Darwaja was built during the Ahmedabad city grew in size. It is built in 1871 for easy access to the railway station. Panchkuwa Darwaja has three gateways of pointed arches, the central one is eighteen feet wide and twenty-eight feet high and two side gateways are seven feet wide and ninteen high.', 'panchkuwa.jpg'),
(9, '1', 'Jamalpur Darwaja', 'This gate is part of fortification walls said to be built during Mohd Begda`s period for protection of the larger city of Ahmedabad in early 15th century.', 'jamalpur.jpg'),
(10, '1', 'Adalaj vav', 'adalaj Stepwell or Rudabai Stepwell  in the village of Adalaj, close to Ahmedabad city and in Gandhinagar district in the Indian state of Gujarat, and considered a fine example of Indian architecture work. It was built in 1498 in the memory of Rana Veer Singh by his wife Queen Rudadevi. Built in sandstone in the Solanki architectural style, the Adalaj stepwell is five stories deep. It is octagonal in plan at the top, built on intricately carved large number of pillars', 'adalaj.jpg'),
(11, '1', 'Dada Harri Ni Vav', 'The stepwell was built in 1485 by Dhai Harir a household lady of Mahmud Begada according to the Persian inscription in the stepwell. She was the superintendent of the royal harem.', 'dadaharinivav.jpg'),
(12, '1', 'laldarwaja', 'Historic Lal Darwaja part of the Old City is home to the 1573 Sidi Saiyyed Mosque famed for its stone latticework windows with geometric and tree-shaped designs. A lively wide promenade runs beside the Sabarmati River with many small temples nearby.', 'lal-darwaza-in-ahmedabad-featured.jpg'),
(13, '1', 'Amritavarshini Vav', 'Panchkuva, literally five wells, area derived its name the five wells in the area. Amritavarshini vav was completed in 1723 as per Devanagari and Persian inscription  in the stepwell. It was built by Raghunathdas, diwan to Haidar Quli Khan, who was the governor of Gujarat during his stay in the city in 1721–1722 for charitable purpose.', 'Amritvarshini_Vav,_Ahmedabad.jpg'),
(14, '1', 'jethabhai''s vav', 'Jethabhai''s Stepwell or Jethabhai ni Vav, is a stepwell in Isanpur area of Ahmedabad, Gujarat, India. It was situated near sha e Alam and one of the heritage stepwells in Ahmedabad.This stepwell was constructed by Jhethabhai Jivanbhai in 18th century A.D.Numerous ancient ornamental parts were used in construction of this Stepwell.', 'jethabhainivav.jpg'),
(15, '1', 'French Haveli', 'The French Haveli’ is an 150 year old, artistically restored Gujarati heritage home. It is a thrill of drama and colours and homeliness. Maintaining its splendid traditional structure, the ‘Haveli’ offers a unique experience of living in the historic community called the ‘Pol’. Living in this house is to experience the Gujarati culture with comfort and luxury. The central court is open to view the sky, which gets in optimum air and light. This is generally the soul of all Havelis. The Jhula (tra', 'Frenchhaveli.jpg'),
(16, '1', 'Mangaldas ni Haveli', 'Estimated to be around 200 years old, Mangaldas ni Haveli is located in Khadia, the heart of the historic walled city of Ahmedabad. It originally belonged to a Nagar Brahmin family and is one of the finest examples of carved wooden architecture typical of that time. This Haveli was bought by the Mangaldas family in 2006 and has been restored with the help of the Heritage Cell of the Ahmedabad Municipal Corporation.', 'mangaldas.jpg'),
(17, '1', 'Jagdip Mehta’s Heritage House', 'This 100 sqm. ground cover and 260 sqm. built-up area ground and two storey house in Khadia III ward lay vacant for more than 18 years. Mr. Jagdip Mehta, who lived in the adjoining house and had bought this structure to accommodate the growing needs of his family, availed the loan facilitated by HUDCO and AHC subsidy to initiate its restoration in January 2004. The restoration work of the house was done with the collaboration of Heritage Department (AMC) and French Government.', 'Jagdip_Mehta_Haveli_1.jpg'),
(18, '1', 'Dodhia Haveli', 'Your home away from home, the Dodhia Haveli, is a picturesque and artistically furnished\r\nwooden heritage house situated in the very heart of Ahmedabad’s Old Quarter. To live here is like going back in time to the city’s rich cultural history when society used to live in the old city quarters called “pols”. These were built during the times of high communal tension and social unrest in the region, hundreds of years ago. Pols are a conglomeration of houses inhabited by people and families who are', 'dodhi_haveli2.jpg'),
(19, '1', 'Harkunvar Baa Ni Haveli', 'Harkunvar Baa Ni Haveli,180 year old Harkunvar Shethani ni Haveli contains 60 rooms, most of which open on to interminable pillared balconies, supported by carved wooden bracket, Stunning wood carvings found feature Indo-Chinese architectural elements.', 'Harkunvar-Shethani-ni-haveli.jpg'),
(20, '1', 'Deewanji ni Haveli', 'As in the Deewanji ni Haveli, here too carpenters and masons were brought in to give an “old look” to new material. French architects helped restore this haveli as part of the Indo-French project, hence the name. “The haveli is a very interesting space, with a large open central courtyard.', 'diwanjinihaveli2.jpg'),
(21, '1', 'Dayabhai Mehta Haveli', 'Dahyabhai Mehta built a very beautiful haveli with magnificent mughal karigari in 1935 which is currently owned by miss Pratima Bhimbhai Mehta. Granddaughter of Mr. Dayabhai Mehta. She has also written a book “Memories of my Pol”. Today this Haveli is also hosts office of an NGO called Chetna Foundation.\r\n\r\nThis 250-years-old haveli, one amongst the many old neglected heritage structures in Khadia’s Desai ni Pol, belongs to freedom fighter Dayabhai Mehta and will be restored into a house museum ', 'dayabhainihaveli1.jpg'),
(22, '2', 'A.G. High school', 'A. G. High School And G & D Parikh Higher Secondary School, is a premier educational institution run under the aegis of The Ahmedabad Education Society and recognized by the department of Education, Gujarat State. At our institute, we aim at a value based education with due emphasis on creating confident, competent, morally and socially mature individuals who are an asset to the society, they live in. Achieving academic excellence is not our only aim. We consciously, aim at stressing upon the students.', ''),
(23, '2', 'Diwan-Ballubhai School', 'One of the finest ICSE schools in Hadapsar, Wisdom World School Hadapsar focusses on a student’s intellectual, cultural and physical growth. As one of the best schools in Pune, Wisdom World School enables your children to grow in a holistic manner and instills in them a love for learning. Since its inception four years ago, the school has witnessed a strong growth of over 1800 students under the able guidance of its Principal, Mrs. Radhika Dalvie has been instrumental in establishing it as a school.', 'diwan-ballubhai.jpg'),
(24, '2', 'Delhi Public School', 'Delhi Public School East with its driving philosophy of “Where Every Child smiles” is considered among the Best School in Ahmedabad. It is affiliated with the Central Board for Secondary Education (CBSE) offering K-12 education. The school offers holistic and over all development of students. It molds and shapes students careers by imparting quality education. Its’ constant efforts to keep up with evolving technologies has made it a pioneering Good CBSE School in Ahmedabad city.', 'delhipublicschool.jpg'),
(25, '2', 'Mahatma Gandhi International School', 'Mahatma Gandhi International School (MGIS), founded in 1998, is an award winning Public-Private Partnership model between the Ahmedabad Municipal Corporation, Municipal School Board and educationalists, Dr. Pascal Chazot and Anju Kawar Chazot. The school integrates a Center for Action Research in Education and a Center for Teacher Training. In addition to in-house training, MGIS founders and senior faculty have mentored schools of various boards to implement the MGIS trademark ‘Generated Resource', 'mahatma-gandhi-international-school-building.jpg'),
(26, '2', 'Nirma University', 'Dr Karsanbhai K Patel, the founder of the Nirma Group of Industries, established the Nirma Education and Research Foundation (NERF) in 1994 with a vision to promote higher education and provide excellent educational facilities to India\\''s youth 1995, Nirma Institute of Technology started in a rented premise with five undergraduate engineering programmed affiliated to Gujarat University. In 1996, the institute started functioning in the new and current campus. ', 'nirmauniversity1.jpg'),
(27, '2', 'St. Xavier''s College', 'St. Xavier`s, Mirzapur had its humble beginnings in 1935.\r\n\r\nThe original building was small, just a few rooms to the right as you enter the compound. The Sisters of Mount Carmel then administered the school. However, after a short stay, they handed over the premises to the Jesuits who had come into Gujarat from Quetta.\r\n\r\nThereafter the school began its growth - both in numbers and buildings. In this process of growth, the school soon outgrew its premises in Mirzapur and to meet the need of the', 'st-xaviers-school-mirzapur-ahmedabad-schools.jpeg'),
(28, '2', 'Udgam School', 'Udgam School is a co-educational English Medium School that follows the CBSE syllabus.\r\n\r\nThe goal of the school is to provide holistic education and circulate the best standards of learning among children, with excellence in academics and co-curricular activities. Focus is given to individual potential and each student is believed to be unique. The method of teaching is child-oriented and the learning atmosphere is warm and friendly. Inculcating values through various practices help to mould th', 'udagamschool1.jpg'),
(29, '3', 'Manek Chowk', 'Manek Chowk is a notable city square in Old Ahmedabad, India. It is surrounded by historical structures. It is a vegetable market in the morning, a bullion market in the noon and the street food market at night. This bustling open square near the center of the city functions as a vegetable market in the morning and a jewellery market in the afternoon, the second biggest in India, at an apparently 3 million rupees of annual turnover. This quarter, the oldest of the city, is named after the 15th century saint Baba Maneknath, who is said to have interrupted Ahmed Shah`s efforts to build the new capital. Each day he would weave a mat while the fort walls were being built, which he would then unravel at night, magically bringing down the walls. When this was discovered, he was invited to prove his powers to Ahmed Shah by putting himself into a small jar. When he did this, Ahmed Shah sealed and buried the jar.', 'manekchowk.jpg'),
(30, '3', 'Rajwadu', 'Once you step into the portals of this experience, you would have stepped into a New World; a world, which takes you back in time. At “Rajwadu”, they not only bring alive the traditional Indian and Gujarati culture but also harp on the need to preserve the same for future generations; quite simply because they want the myriad expressions which have come to occupy the faces to last and be passed on.\r\n“Rajwadu”, a theme based restaurant spread over 12,000 sq. yards represents ancient culture and  lifestyle of villages in India. It begun in August 1998, when Mr. Paresh Patel, Mr. Rajesh Patel and Mr. Manish Patel together planted a promising idea of providing the Ahmedabadis the taste of their very own culture. “Rajwadu”, thus came into existence. The name itself echoes of royalty and tradition.\r\nA quiet and serene place in the suburbs of the bustling city. Tranquil environment, Rajwadi khatla and Traditional Gujarati and Rajasthani food right under the open sky. What more can one ask for', 'Rajwaduhotel1.jpg'),
(31, '3', 'Vishalla', '"Vishalla”, a traditionally designed restaurant, came into existence on 27 March, 1978. The designer, Mr. Surendra Patel, discovered the name "Vishalla"'' in the book Bhakta Chintamani of a religious group called Swaminarayan. This book encompasses the life span of the Swaminarayan Guru. There is a small district in the Himalayas, “Badri Vishala”, which has been widely recognized as a prominent retreat for the “rishi-munis” since time unknown. The place is fit for the purpose owing to its vastness, the ambience and the immense relaxation it offers. “Vishala” found its way into the Swaminarayan book due to the mention of the instance when the Swami went to meditate there. The name caught the sensitive eyes of Mr. Patel as it related to his vision of the restaurant, a place for homely, staple food in a relaxed atmosphere and with a free mind. Vishalla`s portrayal as a typical Indian village can be traced back to the childhood memories of the designer. In the city, he could never find the ', 'vishalla.jpg'),
(32, '3', 'Agashiye', '‘Agashiye’ in Gujarati means ‘on the terrace’. Recognized for serving the best Gujarati thali in India, this restaurant is spread over the entire terrace of the huge mansion and has both outdoor and indoor seating. Here you can enjoy a sit down dinner, exactly how a Gujarati family eats at home. The food is prepared from seasonal ingredients and served unlimited in a ‘Kansa thali’, a plate made from alloy with medicinal properties. Much like the city and its people, Agashiye celebrates traditional Gujarati food made fresh. A Jain menu is available on request.', 'agashiye.jpg'),
(33, '3', 'Hyatt Hotel', 'Hyatt Hotels Corporation, commonly known as Hyatt Hotels & Resorts, is an American multinational hospitality company headquartered in the Riverside Plaza area of Chicago that manages and franchises luxury and business hotels, resorts, and vacation properties.', 'hyatt.jpg'),
(34, '3 ', 'THE GRAND BHAGWATI', 'THE GRAND BHAGWATI IS A CHAIN OF HOTELS KNOWN FOR IT’S EXCELLENT FOOD, DISTINGUISHED HOSPITALITY, MAGNIFICENT BANQUET SPACE AND OUTDOOR CATERING SEGMENT ACROSS INDIA.\r\n\r\nBhagwati Group was found in 1989 by the visionary entrepreneur par excellence Mr. Narendra Somani - The Chairperson & Managing Director whose revolutionary business acumen and enterprising attitude created this enterprise from the ground up. TGB Banquets & Hotels Ltd – a renowned public limited company, listed on BSE and NSE exchange, with its vision and novel innovations has created an admired empire in the field of food and hospitality industry. The banner of Bhagwati Caterers Pvt Ltd which was incorporated on 03/10/1997. operations from June 2002 under the flagship of the Issuer Company BBHL. and a captive, easy parking facility to match the size of its banquet facility. company was changed to "Bhagwati Banquets And Hotels Limited".', 'the-grand-bhagwati.jpg'),
(35, '3', 'Iscon Thal', 'Iscon Thal is the trio of Authenticate Gujarati Taste, vivid locus of Iscon cross road and good service. It is a proud venture of Surbhi Group (Junagadh Wala) established with an aim to serve Gujarati’s very own staple foods & traditional sweets in a “THAL”. Iscon Thal is a fully air-conditioned restaurant with professionally trained staff and adept chefs. Iscon Thal an honourable mention when it comes to the Gujarati food. It is one of the best dinner place in Ahmedabad and is also one of the top rated restaurants in Ahmedabad. It is an ideal place to enjoy having a gala time with your family members in the company of some really good Gujarati food dishes and Gujarati thalis. Never mind whether you are new or old to the city of Ahmedabad, if you wish to discover the taste & true spirit of Gujarati cuisine you must walk-in-at one of the best dinner place in Ahmedabad; Iscon Thal. It is indeed a flavourful and delightful heaven for the foodies.', 'isconthal1.jpg'),
(36, '3', 'Happy Street', 'Happy Street dedicated parking slots and a cycle track on one side of it. There are slots for 42 food vans to operate from evening to dawn, over a 300-metre stretch. According to the AMC, there are 31 big stalls that have been let at a price of Rs 167 lakh a month. Eleven stalls were let out for Rs 90,000 a month. For the remaining two small stalls, the highest bids were Rs 73,000 a month. The street, between the NCC compound and Law Garden Circle, has been brightly lit and has special street marketing and furniture. While inaugurating the street, Rupani said the AMC had given this long-running street a heritage look, modern infrastructure and hygienic food. He said all wards in the city should have such streets. Rupani also called on other municipal corporation in the state of replicate this project. ', 'happy-street4.jpg'),
(37, '4', 'Himalaya mall', 'Himalaya Mall is located at Vastrapur area of Ahmedabad. It is a bit old mall, average kind. Croma, Burger King, Domino''s Pizza and Mc Donald''s with Food Carnival  with parking facilities.', 'himalyamall1.jpg'),
(38, '4', 'Ahmedabad One Mall', 'Ahmedabad One is a shopping mall located at Vastrapur, Ahmedabad, India. The mall was opened in October 2011 and is the largest mixed used city center in Ahmedabad. The mall faced protests from the nearby residents during its launch. The mall is located in a neighborhood consisting of people who are strictly vegetarians, who protested against KFC opening an outlet in the mall as it is a non-vegetarian restaurant. Protests were also raised against Cinepolis multiplex as it is situated within 200 meters of a religious place.', 'ahmedabadonemall.jpg'),
(39, '4', 'Dhalgarwad', 'Dhalgarwad, near Teen Darwaja, is a lively cloth market selling a wide variety of fabrics at reasonable prices. From here travel southward to Khamasa Chowki, where within a 1 km radius, there is a place of worship for almost every religious faith in India. Ahmedabad’s only synagogue is just north of this chowki.', 'dhalgarwad1.jpg'),
(40, '4', 'Gujari - Mercado Ravivar', 'Every Sunday, the open space underneath the eastern end of Ellis Bridge becomes one of the largest market areas in the city. Beginning alongside the bridge, continuing downhill, and sprawling across the area underneath it and along the riverfront, the market sprouts several hundred stalls selling everything one could possibly need. As a distinctly pragmatic market, however, you will see hardly any stalls hawking useless goods, tourist trinkets, pointless decorations, and so forth. Principle items include all manner of kitchen supplies, tools, furniture, hardware, clothing, electronics, used books, bedding, antiques, goats and chickens and any other household goods you could imagine. It is a lively, chaotic and always surprising experience.', 'gujari1.jpg'),
(41, '4', 'Law Garden', 'Law Garden is a public garden in the city of Ahmedabad, India. The market outside the garden is very famous for the handicraft goods sold by local people. The road at the side of the garden is filled with street hawkers selling a variety of food items. The Law Garden market is known for its collection of textiles and white metal jewels. Foreigners usually visit the market for the Indian handicrafts sold here by the local people.', 'Law-Garden-Night-Market1.jpg'),
(42, '4', 'Flower Market', 'The Jamalpur market was started in 1989 and thereafter they are continuing the same trade over generations. The majority of traders are from Gujarat. The major flowers get sold at Jamalpur are marigold, mogra, gallad, rajnigandha, jharmara. From Jamalpur flower are sold to retailers situated in Ahmedabad''s various areas like Navrangpura, CG road, Satellite etc.', 'Flower_market1.png'),
(43, '4', 'New Cloth Market', 'The New Cloth Market was a mega initiative whose foundation stone was laid in the year 1959. The New Cloth Market had been started as an offshoot of already existing Maskati Cloth Market Mahajan. The idea was to cater the needs of ever increasing and ever changing demands of wholesales textile trade. The inauguration of the market was done by the then President of India Hon`ble Dr. Sarvepalli Radhakrishnan. In the New Cloth Market, the entire chain of Textile Trading activity is going on. Offices of all major Cotton Traders, Spinning Mills, Sizers, Weavers and Processors are situated here. It has contributed in the developed of wholesale textile market in Ahmedabad. The New Cloth Market Association has always been a step ahead in philanthropy and social service for healthcare, education and community welfare. A hospital is functioning in the market where two permanent MBBS and specialists doctors are providing services regularly at token charges. Medical camps and blood donation camps ', 'New-Cloth-Market1.jpg'),
(44, '4', 'Chandla OL', 'Chandla OL is one of the biggest and oldest market for brass pooja items in Ahmedabad city. You will find all the brass puja items at this place like Sev-Sancha, Table Ware, Idols, Statues, Puja Thali, Copper Lota, Brass Camps, Lemon Saucer, Puri Press, Flower Vase and much more as per the Festival & Occasions.', 'Chandla-ol-1.jpg'),
(45, '5', 'Law Garden', 'Law Garden, a lush green garden in the middle of a bustling city, is located in Ahmedabad in the colorful Indian state of Gujarat. This well-maintained oasis is frequently visited by locals for recreational purposes. The garden is famous for its market where tourists and locals indulge in shopping and find great deals. The night market is a treat for shoppers as the true colours of Vibrant Gujarat shimmer in the kiosks, and one can find intricate traditional work on the flamboyant items on sale. It''s a fabulous place to buy traditional Gujarati apparel, accessories, ornaments and handicraft with traditional handwork on them.', 'Law-Garden2.jpg'),
(46, '5', 'Parimal Garden', 'Located on the Parimal Cross Road in Ambavadi, Parimal Garden is a beautiful well-maintained garden in the heart of Ahmedabad. Replete with swings and dotted with stone benches, the park is popular among both adults and kids alike. Mostly used for morning and evening walks, the garden also has routine laughing clubs for the elderly.', 'parimal-garden-ahmedabad1.jpg'),
(47, '5', 'One Tree Hill Garden', 'One Tree Hill Garden located in Kankaria in Ahmedabad is synonymous with beauty. Boasting of a charming lake, charming gateways, well-maintained lawns, orderly flower beds and charming fountains, the garden also has the ruins of an ancient structure as a décor to its ambiance. It is one of the most visited and finest gardens in the city.', 'one-tree-hill-garden-in-ahmedabad-featured1.jpg'),
(48, '5', 'Victoria Garden', 'Victoria Garden is situated in the south of Ahmedabad near Bhadra Fort. The garden spells beauty and charm with its well-maintained lawns, pretty flower beds, rejuvenation trees and spacious play areas. The garden also has a life like statue of Queen Victoria installed in the heart of it.', 'victoria-garden.png'),
(49, '5', 'Vastrapur Lake Garden', 'Situated in Western Ahmedabad, Vastrapur Lake is an ancient lake which was renovated and prettified in 2002 and in 2013 a huge statue of Narsinh Mehta (a famous poet saint of Gujarat), was installed and the lake was named after him. The lake has an adjoining garden full of green trees and vibrant flower beds. It boasts of an open air theatre which is used for organizing several cultural events of the city.', 'vastrapur.jpg'),
(50, '5', 'AUDA Garden', 'Situated in Bodakdev in Ahmedabad, AUDA Garden boasts of vast stretches of well-maintained green lawns, tall towering shady trees and a peaceful ambiance. The garden has patches of lovely flower beds lighting up the space with vibrant colorful flowers. It is a perfect place to escape the chaos of the city to relax and rewind amidst natural surroundings.', 'auda_garden.jpg'),
(51, '5', 'Gotila Garden', 'Gotila Garden-Talav is a vibrant green garden situated in Sindhubhavan Road, Thaltej in Ahmedabad. Blessed with vibrant flowers, beautifyl water sprinklers, quaint benches and shady trees, the garden is a haven for city dwellers as well as birds. People also come here to look at the numerous birds that flock the place at early morning or late evening.', 'gotila1.jpg'),
(52, '6', 'Kankariya Lake', 'Kankaria Lake is the second largest lake of Ahmedabad, formerly known as Hauz-e-Qutub. Located near the Maninagar area, the lakefront is popular for the balloon safari, zoo, toy trains and the amusement park. The pristine lake is perfect for evening strolls with multi-coloured lights glowing all around its periphery. For adventure buffs, Kankaria Lake lays down a plethora of options like archery, gymnastics and water rides. The most beguiling festival - Kankaria carnival is celebrated with immense vim and vigor. Kankaria Lake is a place where entertainment, culture, knowledge and talent perfectly blend with each other.', 'kankariya.jpg'),
(53, '6', 'Vastrapur Lake ', 'Situated in Western Ahmedabad, Vastrapur Lake is an ancient lake which was renovated and prettified in 2002. A huge statue of Narsinh Mehta , was installed here and the lake was named after him as the Bhakt Kavi Narasinh Mehta Sarovar. It boasts of an open-air theatre which is used for organising several cultural events of the city. When there was an alarm of the Vastrapur Lake drying up in 2016, the local authorities ensured moving the fish and other aqua life to a safer place. However, many fishes had already died by then. In the year 2019, the AMC  opened the route for river Narmada to flow into the lake, which was initially only occasional.', 'vastrapur-lake1.jpg'),
(54, '6', 'Chandola Lake', 'Chandola Lake was established by the wife of a Mughal Sultan of Ahmedabad named Tajn Khan Nari Ali. It was in existence when Asha Bhil founded Ashaval. The historic Salt March around nine in the morning, after covering a distance of seven miles from the Sabarmati Ashram and a few minutes after the trucks and the taxis carrying radio and print journalists had disappeared down the road, had reached the Chandola Lake. Mahatma Gandhi had stopped under a large pipal tree next to the lake, no bigger than a small pond in the middle of a vast expanse of mud during March, 1930. Chandola Lake is located near Dani Limda Road, Ahmedabad, Gujarat state, India and covers an area of 1200 hectares. It is a water reservoir, embanked and circular in form. It is also home for cormorants, painted storks and spoonbill birds.', 'Chandola_lake.jpg'),
(55, '7', 'Auto World Vintage Car Museum', 'Located in the Dastan of Kathwad, the Auto World Vintage Car Museum is a connoisseur of over 120 vintage cars including old utility vehicles, motor vehicles and ancient carriages. It is organized and maintained by the Vintage and Classic Car Club of India. The museum also houses a cafe and a museum shop with ample parking space and toilet facilities. Started by Shri Pranlal Bhogilal Patel who transformed his private collection into a renowned museum, the Auto World Vintage Car Museum is presently managed by the Director, Mr. Nitin Dosin. The museum also houses an array of royal cars and carriers ranging between 1900 to the 1970s. Most of them belonged to some of the most prominent Kings or Maharajas of the time and some notable colonizers of the country as well. The signature exhibits include the 1949 Rolls Royce, 1906 Minerva, 1927 Phantom I and the 1923 Silver Ghost including the iconic French Hotchkiss cars. The oldest antique here is the 1903-model of Fiat.', 'Auto World-vintage-car-museum-ahmedabad.jpg'),
(56, '7', 'Sardar Vallabhbhai Patel National Memorial', 'Situated in the premises of Moti Shahi Mahal at Shahibaug in Ahmedabad, Sardar Vallabhai Patel National Museum is a museum and a memorial dedicated to the 1st Deputy Prime Minister of India - Sardar Vallabhai Patel. The museum has exhibitions in English, Hindi and Gujarati. Surrounded by a beautiful garden, the museum also has umpteen exhibits and photographs from the Indian National Movement and specifically from Patel''s life. The memorial exhibits over a thousand of memoirs and relics that were significant to Sardar Vallabhbhai Patel and his life. One highlighted feature of the museum is the original Indian flag from the 1930s designed by the Congress party of the time.', 'sardarpatelmemorial.jpg'),
(57, '7', 'Vechaar Utensil Museum', 'Vishalla prides itself on its presentation of Indian culture and tradition in its village-like environment with its museum of old utensils known as Vechaar. The museum found its way into Vishalla three years after Vishalla was itself started, on 27 April 1981. Vechaar is the only museum of its kind in the world, displaying such a precious collection of utensils. The designer of Vishalla, Mr. Patel, shares his success in the establishment of Vechaar with Mr. Jyontindra Jain, a well-known anthropologist.', 'vechaar_museum.jpg'),
(58, '7', 'Gujarat Science City', 'Gujarat Science City, located in Hebatpur, Ahmedabad, is a part of Gujarat government''s initiative to draw more students towards education in science. The center hosts an IMAX 3D theatre, an energy park, a hall of science, Planet Earth, an amphitheater, Life Science Park and dancing musical fountains among others.[1] The center also provides housing for students preparing for science exams. For last few years, a program called "Vacation Training Program on Bioresearches for school children" is being organized by Science city with the help of government funds to encourage students regarding Bioresearches. It is a month-long program for students who gave their SSC exams, each from every district of the state.', 'science-city.jpg'),
(59, '8', 'Shree Swaminarayan Mandir Kalupur ', 'Shree Swaminarayan Mandir Kalupur  is the first Temple of the Swaminarayan Sampraday, a Hindu sect. It is located in Kalupur area of Ahmedabad, the largest city in Gujarat, India. It was built on the instructions of Swaminarayan, the founder of the sect. As per the will of Swaminarayan, the administration of the Swaminarayan Sampraday is divided into two Gadi (seats) - Nar Narayan Dev Gadi and Laxmi Narayan Dev Gadi. This Temple is the headquarters of the Nar Narayan Dev Gadi.', 'swaminarayan-temple-kalupur-ahmedabad.jpg'),
(60, '8', 'Hutheesing Temple ', 'Hutheesing Temple  is the best known Jain temple in Ahmedabad in Gujarat. It was constructed in 1848. The construction of the temple was initiated originally planned by Sheth Hathisinh Kesarisinh, a wealthy Ahmedabad trader who died at 49. The construction was supervised and completed by his wife Shethani Harkunvar. The total cost was approximately Rs. 8 lakh. Then a major sum. The temple is dedicated to Lord Dharmanatha, the fifteenth Jain Tirthankar.', 'hathee-singh-temple-ahmedabad-entry-fee-timings-holidays-reviews-header.jpg'),
(61, '8', 'The Shree Camp Hanuman Temple', 'The Shree Camp Hanuman Temple is one of the biggest Hanuman temples of India. It is situated in Ahmedabad Cantonment area in Shahibaug, Ahmedabad, Gujarat. This temple was owned by Smt. Lalitaben Dave and Smt. Shivagangaben Trivedi. Shri Gajanand was employed by them to do Sewa Puja in this temple in or around 1920. In 1952 the original owners handed over the temple for forming a charitable trust named Shri Hanumanji Mandir Camp Trust Ahmedabad. ', 'kempna-hanuman.jpg'),
(62, '8', 'Jagannath Temple', 'The Jagannathan Temple is a temple dedicated to the Hindu God Jagannathan in the city of Ahmedabad in the Gujarat state of India. The temple located in the Jamalpur locality was established by Sadhu Sarangdasji about 450 years ago. The temple is famous for its annual chariot festival, the Rath Yatra, which is the third most important and largest after the Ratha Yatra at Puri.  As per tradition elephants have the first glimpse of Jagannathan, his brother Balabhadra and sister Subhadra and lead the procession.', 'jagganath.jpg'),
(63, '8', 'Vaishnov Devi Temple', 'It is located on the Gandhinagar road and is one of the best temples in Ahmedabad. This temple is a replica of the Mata Vaishno Devi Shrine in Jammu & Kashmir. It has been made on a man-made hill and one needs to climb up the hill to visit this temple. You should visit here during the festival of Navratri. All the nine days of the festival are celebrated here with much enthusiasm. There is also a Tirupati Balaji Temple nearby, which you can cover when visiting this temple.', 'vaishnovdevi-temple.jpg'),
(64, '8', 'Jama Masjid ', 'Jama Masjid also known as Jumah Mosque, is a mosque in Ahmedabad, India built in 1424 during the reign of Ahmad Shah. Lying in the old walled city, the mosque is situated outside Bhadra Fort area, along the south side of the road extending from Teen Darwaja to Manek Chowk.', 'Jama-(Jumma)-Masjid-Thumbnail.jpg'),
(65, '9', 'Sidi Bashir Mosque ', 'Sidi Bashir Mosque is a former mosque in the city of Ahmedabad, Gujarat, India. Only the central gateway and two minarets survive; they are known as the Jhulta Minar or Shaking Minarets. The mosque is believed to have been constructed either by Sidi Bashir, a slave of Sultan Ahmed Shah, or by Malik Sarang, a noble in the court of Mahmud Begada, another Sultan of Gujarat. It has been dated to 1452 although the style and material of the minarets point to the close of Mahmud Begada''s reign or later. ', 'zultaminara.jpg'),
(66, '9', 'Sabarmati Ashram', 'Sabarmati Ashram  is located in the Sabarmati suburb of Ahmedabad, Gujarat, adjoining the Ashram Road, on the banks of the River Sabarmati. This was one of the many residences of Mahatma Gandhi who lived at Sabarmati and Sevagram  when he was not travelling across India or in prison. It was from here that Gandhi led the Dandi march also known as the Salt Satyagraha on 12 March 1930. In recognition of the significant influence that this march had on the Indian independence movement, the Indian government has established the ashram as a national monument. Gandhiji''s India ashram was originally established at the Kocharab Bungalow of Jivanlal Desai, a barrister and friend of Gandhi, on 25 May 1915. At that time the ashram was called the Satyagraha Ashram. ', 'Sabarmati-Ashram.jpg'),
(67, '9', 'Bhadra Fort', 'Located at the walled city of Ahmedabad, the 44 acre-Bhadra fort composes of intricate carvings, latticework and frescos alongside impeccable arches and inscriptions at the entrance. Built in 1411 by Ahmed Shah I, the walling is said to have been established to protect the Gujarat Sultanate, reigned by Ahmed Shah I at the time. Ahmedabad was named after Ahmad Shah I of the Muzaffarid dynasty. He established Ahmedabad as the new capital of Gujarat Sultanate and built Bhadra Fort on the east bank of the Sabarmati river. It was also known as Arak Fort as described in Mirat-I-Ahmadi.', 'bhadranokillo.jpg'),
(68, '9', 'ISKCON Temple', 'Located close to the Gujarat Samachar Press, The ISKCON Temple in Ahmedabad is the best place to experience spirituality and mental bliss. Also referred to as the ''Hare Krishna Temple'', this temple with its calm and peaceful atmosphere, offers the perfect spot for meditation. Inside the Hare Krishna Mandir, one can always hear the chantings of Hare Rama Hare Krishna. Many devotional lectures and addresses are arranged for the benefit of devotees, especially those with a spiritual bent of mind. The followers hold sessions in institutes, corporates, etc., to teach the techniques of spiritualizing the daily life. The constant chanting of the holy names is a special feature at the center.', 'iskcon-temple.jpg'),
(69, '9', 'Hare Krishna Mandir', 'Hare Krishna Mandir, Bhadaj, is one of the most renowned places to visit in Ahmedabad. Since its inauguration in April 2015, the temple has been standing as a beacon of spirituality and service to the mankind. Being one of the most popular places in Ahmedabad, Hare Krishna Mandir is not visited just by the devotees seeking Lord’s blessings but also by those who are looking for spiritual solace, away from the din and is easily accessible by road. The temple is dedicated to serving the mission of His Divine Grace Srila Prabhupada, the Founder Acharya of the worldwide Hare Krishna Movement. ', 'hare-krishna.jpg'),
(70, '9', 'Sundarvan ', 'Small children''s nature center featuring various plants & animals, plus educational activities. It is one type of zoo with some animals and birds. This place is very good for Children''s.', 'sundarvan.jpg'),
(71, '9', 'The Narendra Modi Stadium', 'The Narendra Modi Stadium, commonly known as the Motera Stadium, is a cricket stadium situated inside the Sardar Patel Sports Enclave in Ahmedabad, Gujarat, India. India. As of 2020, it is the largest cricket stadium in the world and the second largest stadium overall, with a seating capacity of 132,000 spectators. It is owned by the Gujarat Cricket Association and is a venue for Test, ODI, and T20I cricket matches. ', 'moterastadium.jpg'),
(72, '10', 'Sardar Vallabhbhai Patel International Airport', 'Sardar Vallabhbhai Patel International Airport is an international airport serving the twin cities of Ahmedabad and Gandhinagar in Gujarat, India. The airport is located in Hansol, 9 km (5.6 mi) north of central Ahmedabad. It is named after Sardar Vallabhbhai Patel, the 1st Deputy Prime Minister of India. The Airport is the busiest and largest airport in the Indian state of Gujarat. ', 'sardarpatelairpot.jpg'),
(73, '10', 'Kalupur Railway Station', 'Kalupur Railway Station Ahmedabad Junction railway station is the main railway station of Ahmedabad, Gujarat, India. Ahmedabad Junction Railway Station code is ADI.', 'Ahmedabad_Station.jpg'),
(74, '10', 'Maninagar railway station', 'Maninagar railway station is a major railway station in South Zone, Ahmedabad, India. This railway station is in a developed suburban area of Ahmedabad. It is well connected by rail. It is located 3 km away from Ahmedabad Junction. Sixty-two trains halt here.', 'maninagarrailwaystation.jpg'),
(75, '10', 'Gita Mandir Bus Depot', 'Gita Mandir Road is an area located in Ahmedabad, India. It is one of the Bus depot in Ahmedabad.  ', 'ahmedabad_geeta_mandir_bus_stand1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `place_category`
--

CREATE TABLE `place_category` (
  `Category_id` int(30) NOT NULL,
  `Category_name` varchar(50) NOT NULL,
  `Category_photo_path` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `place_category`
--

INSERT INTO `place_category` (`Category_id`, `Category_name`, `Category_photo_path`) VALUES
(1, 'Historical Places', 'lal_darwaza_in_ahmedabad_featured.jpg'),
(2, 'Educational institution', 'A.g.%20high_school.jpg'),
(3, 'Food', 'happy_street1.jpg'),
(4, 'Markets', 'Chandla-ol-2.jpg'),
(5, 'Gardens', 'Law-Garden2.jpg'),
(6, 'Lakes', 'kankariyalake.jpg'),
(7, 'Museums', 'vechaar_museum.jpg'),
(8, 'Religious ', 'iskcon_temple.jpg'),
(9, 'Famous', 'moterastadium.jpg'),
(10, 'Transportation', 'Ahmedabad_Station.jpg');

-- --------------------------------------------------------

--
-- Stand-in structure for view `place_report`
--
CREATE TABLE `place_report` (
`Place_id` int(11)
,`Place_title` varchar(200)
,`Place_details` text
,`Category_id` int(30)
,`Category_name` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `Route_id` int(11) NOT NULL,
  `Route_details` varchar(500) NOT NULL,
  `Route_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`Route_id`, `Route_details`, `Route_type`) VALUES
(2, 'Shivaranjani', 'rikshaw'),
(3, 'chankyapuri', 'Bus');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bus`
--

CREATE TABLE `tbl_bus` (
  `bus_id` int(11) NOT NULL,
  `bus_no` varchar(50) NOT NULL,
  `source_title` varchar(100) NOT NULL,
  `source_lat` varchar(50) NOT NULL,
  `source_long` varchar(50) NOT NULL,
  `destination_title` varchar(100) NOT NULL,
  `destination_lat` varchar(50) NOT NULL,
  `destination_long` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_bus`
--

INSERT INTO `tbl_bus` (`bus_id`, `bus_no`, `source_title`, `source_lat`, `source_long`, `destination_title`, `destination_lat`, `destination_long`) VALUES
(1, '77', 'Vadaj', '23.060270', '72.567642', 'Hatkeshwar', '22.991650', '72.620770'),
(2, '48', 'Jodhpur', '23.0329188', '72.5176796', 'Lal Darwaja', '23.0306053', '72.5781372');

-- --------------------------------------------------------

--
-- Table structure for table `user_master`
--

CREATE TABLE `user_master` (
  `User_id` int(11) NOT NULL,
  `User_name` varchar(20) NOT NULL,
  `User_email` varchar(50) NOT NULL,
  `User_password` varchar(20) NOT NULL,
  `User_mobileno` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_master`
--

INSERT INTO `user_master` (`User_id`, `User_name`, `User_email`, `User_password`, `User_mobileno`) VALUES
(2, 'Dhara', 'dha12@gmail.com', 'DHA@#123dhara', '1234567890'),
(4, 'Sakshi', 'sakshi.patwari0', 'Sakshi@2003', '9986153340'),
(5, 'Shruti', 'shrutirathod11@', 'Shruti11@11', '1234509876'),
(7, 'Sadhya', 'abc@gmail.com', '123', '9924153678'),
(8, 'test', 'test@gmail.com', '123', '7048390515'),
(10, 't1', 'test1@gmail.com', '12', '7048390515'),
(11, 'test', 'test2@gmail.com', '123', '7048390515'),
(12, 'test', 'vasup1041@gmail.com', '12', '7048390564');

-- --------------------------------------------------------

--
-- Structure for view `place_report`
--
DROP TABLE IF EXISTS `place_report`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `place_report`  AS  select `place`.`Place_id` AS `Place_id`,`place`.`Place_title` AS `Place_title`,`place`.`Place_details` AS `Place_details`,`place_category`.`Category_id` AS `Category_id`,`place_category`.`Category_name` AS `Category_name` from (`place` join `place_category` on((`place`.`Place_id` = `place_category`.`Category_id`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_master`
--
ALTER TABLE `admin_master`
  ADD PRIMARY KEY (`Admin_id`),
  ADD UNIQUE KEY `Admin_email` (`Admin_email`);

--
-- Indexes for table `event_master`
--
ALTER TABLE `event_master`
  ADD PRIMARY KEY (`Event_id`),
  ADD KEY `Event_type_id` (`Event_type_id`);

--
-- Indexes for table `event_type`
--
ALTER TABLE `event_type`
  ADD PRIMARY KEY (`Event_type_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`Feedback_id`),
  ADD KEY `User_id` (`User_id`);

--
-- Indexes for table `news_master`
--
ALTER TABLE `news_master`
  ADD PRIMARY KEY (`News_id`);

--
-- Indexes for table `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`Place_id`);

--
-- Indexes for table `place_category`
--
ALTER TABLE `place_category`
  ADD PRIMARY KEY (`Category_id`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`Route_id`);

--
-- Indexes for table `tbl_bus`
--
ALTER TABLE `tbl_bus`
  ADD PRIMARY KEY (`bus_id`);

--
-- Indexes for table `user_master`
--
ALTER TABLE `user_master`
  ADD PRIMARY KEY (`User_id`),
  ADD UNIQUE KEY `User_email` (`User_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_master`
--
ALTER TABLE `admin_master`
  MODIFY `Admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `event_master`
--
ALTER TABLE `event_master`
  MODIFY `Event_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `event_type`
--
ALTER TABLE `event_type`
  MODIFY `Event_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `Feedback_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `news_master`
--
ALTER TABLE `news_master`
  MODIFY `News_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `place_category`
--
ALTER TABLE `place_category`
  MODIFY `Category_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
  MODIFY `Route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_bus`
--
ALTER TABLE `tbl_bus`
  MODIFY `bus_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user_master`
--
ALTER TABLE `user_master`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
