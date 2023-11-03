package com.server.tori;

import com.server.tori.entity.Landmark;
import com.server.tori.repository.LandmarkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ToriApplicationTests {

	@Autowired
	private LandmarkRepository landmarkRepository;

	@Test
	void testJpa() {

		List<String> category1 = new ArrayList<>();
		List<String> location1 = new ArrayList<>();
		List<String> image1 = new ArrayList<>();

		Landmark l1 = new Landmark("행주 산성", "경기도 고양시 덕양구 행주로 15번길 89", "임진왜란 3대첩 '행주대첩'의 승전지", 37.600222769591255, 126.82528030291823,
				"무료", "09:00 - 17:00", "https://www.goyang.go.kr/haengju/index.do", "한국어", category1, location1, image1);
		l1.getCategory().add("역사");
		l1.getCategory().add("전통 문화");
		l1.getCategory().add("체험");
		l1.getLocation().add("서부");
		l1.getLocation().add("북부");
		l1.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/160756ba-f0b4-4095-a029-14d52427245f/%EA%B3%A0%EC%96%91_%ED%98%B8%EC%88%98%EA%B3%B5%EC%9B%90.jpg?id=f90e2d9e-22b5-46b6-9017-d8d4145b0321&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=guxaKDJdHZizSgQyjZsNvty6eWpje9c17KHSe_5z7qA&downloadName=%EA%B3%A0%EC%96%91+%ED%98%B8%EC%88%98%EA%B3%B5%EC%9B%90.jpg");
		l1.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/160756ba-f0b4-4095-a029-14d52427245f/%EA%B3%A0%EC%96%91_%ED%98%B8%EC%88%98%EA%B3%B5%EC%9B%90.jpg?id=f90e2d9e-22b5-46b6-9017-d8d4145b0321&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=guxaKDJdHZizSgQyjZsNvty6eWpje9c17KHSe_5z7qA&downloadName=%EA%B3%A0%EC%96%91+%ED%98%B8%EC%88%98%EA%B3%B5%EC%9B%90.jpg");
		l1.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/160756ba-f0b4-4095-a029-14d52427245f/%EA%B3%A0%EC%96%91_%ED%98%B8%EC%88%98%EA%B3%B5%EC%9B%90.jpg?id=f90e2d9e-22b5-46b6-9017-d8d4145b0321&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=guxaKDJdHZizSgQyjZsNvty6eWpje9c17KHSe_5z7qA&downloadName=%EA%B3%A0%EC%96%91+%ED%98%B8%EC%88%98%EA%B3%B5%EC%9B%90.jpg");
		this.landmarkRepository.save(l1);

		List<String> category2 = new ArrayList<>();
		List<String> location2 = new ArrayList<>();
		List<String> image2 = new ArrayList<>();

		Landmark l2 = new Landmark("화담숲", "경기도 광주시 도척면 도척윗로 279-1", "LG 상록재단이 공익사업의 일환으로설립 운영하는 수목원", 37.600222769591255, 126.82528030291823,
				"무료", "09:00 - 17:00", "https://www.goyang.go.kr/haengju/index.do", "한국어", category2, location2, image2);
		l2.getCategory().add("자연");
		l2.getCategory().add("체험");
		l2.getCategory().add("인생샷");
		l2.getLocation().add("남부");
		l2.getLocation().add("동부");
		l2.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/46b4850b-6ebe-4c4c-aab7-69a1e4c9ab04/%EA%B3%A0%EC%96%91_%ED%96%89%EC%A3%BC%EC%82%B0%EC%84%B1.jpg?id=a4112ed7-a0ae-42d7-ba4c-a85b9a4701f0&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=qocomhTpAqfhYnL15dT10AAu0cVX4BszpjPsx8qnZ78&downloadName=%EA%B3%A0%EC%96%91+%ED%96%89%EC%A3%BC%EC%82%B0%EC%84%B1.jpg");
		l2.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/46b4850b-6ebe-4c4c-aab7-69a1e4c9ab04/%EA%B3%A0%EC%96%91_%ED%96%89%EC%A3%BC%EC%82%B0%EC%84%B1.jpg?id=a4112ed7-a0ae-42d7-ba4c-a85b9a4701f0&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=qocomhTpAqfhYnL15dT10AAu0cVX4BszpjPsx8qnZ78&downloadName=%EA%B3%A0%EC%96%91+%ED%96%89%EC%A3%BC%EC%82%B0%EC%84%B1.jpg");
		l2.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/46b4850b-6ebe-4c4c-aab7-69a1e4c9ab04/%EA%B3%A0%EC%96%91_%ED%96%89%EC%A3%BC%EC%82%B0%EC%84%B1.jpg?id=a4112ed7-a0ae-42d7-ba4c-a85b9a4701f0&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=qocomhTpAqfhYnL15dT10AAu0cVX4BszpjPsx8qnZ78&downloadName=%EA%B3%A0%EC%96%91+%ED%96%89%EC%A3%BC%EC%82%B0%EC%84%B1.jpg");
		this.landmarkRepository.save(l2);

		List<String> category3 = new ArrayList<>();
		List<String> location3 = new ArrayList<>();
		List<String> image3 = new ArrayList<>();

		Landmark l3 = new Landmark("유니온 타워", "경기 하남시 미사대로 710", "한강·검단산 등 하남의 아름다운 경관을 한눈에 조망할 수 있는 하남유니온타워", 37.600222769591255, 126.82528030291823,
				"무료", "09:00 - 17:00", "https://www.goyang.go.kr/haengju/index.do", "한국어", category3, location3, image3);
		l3.getCategory().add("도시");
		l3.getCategory().add("체험");
		l3.getCategory().add("인생샷");
		l3.getLocation().add("남부");
		l3.getLocation().add("동부");
		l3.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/9800775b-b633-4dc3-a683-34876360ea9f/%EA%B3%A0%EC%96%91_%EC%84%9C%EC%98%A4%EB%A6%89.jpg?id=579dc96e-4404-4fb8-86e0-2ae7ff60d9a8&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=2HWW_HgMOzRHabZXs7L3_n_NemBHuZnZvnqGxFrbLjo&downloadName=%EA%B3%A0%EC%96%91+%EC%84%9C%EC%98%A4%EB%A6%89.jpg");
		l3.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/9800775b-b633-4dc3-a683-34876360ea9f/%EA%B3%A0%EC%96%91_%EC%84%9C%EC%98%A4%EB%A6%89.jpg?id=579dc96e-4404-4fb8-86e0-2ae7ff60d9a8&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=2HWW_HgMOzRHabZXs7L3_n_NemBHuZnZvnqGxFrbLjo&downloadName=%EA%B3%A0%EC%96%91+%EC%84%9C%EC%98%A4%EB%A6%89.jpg");
		l3.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/9800775b-b633-4dc3-a683-34876360ea9f/%EA%B3%A0%EC%96%91_%EC%84%9C%EC%98%A4%EB%A6%89.jpg?id=579dc96e-4404-4fb8-86e0-2ae7ff60d9a8&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=2HWW_HgMOzRHabZXs7L3_n_NemBHuZnZvnqGxFrbLjo&downloadName=%EA%B3%A0%EC%96%91+%EC%84%9C%EC%98%A4%EB%A6%89.jpg");
		this.landmarkRepository.save(l3);

		List<String> category4 = new ArrayList<>();
		List<String> location4 = new ArrayList<>();
		List<String> image4 = new ArrayList<>();

		Landmark l4 = new Landmark("출판도시 지혜의 숲", "경기도 파주시 희동길 145", "차를 마시며 책을 읽을 수 있는 전시 공간, 독서 공간을 갖춘 열린 문화공간", 37.600222769591255, 126.82528030291823,
				"무료", "09:00 - 17:00", "https://www.goyang.go.kr/haengju/index.do", "한국어", category4, location4, image4);
		l4.getCategory().add("자연");
		l4.getCategory().add("인생샷");
		l4.getLocation().add("북부");
		l4.getLocation().add("서부");
		l4.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/056bf902-87bb-43f7-84c7-5eaa969ad36a/%ED%8C%8C%EC%A3%BC_DMZ.jpg?id=82fac830-6eba-411f-a6ff-a36cf9cf8d18&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=I0KVb1LOsrJpV2czX7ybuG8d3N7dCx3AiRjdIOnpLig&downloadName=%ED%8C%8C%EC%A3%BC+DMZ.jpg");
		l4.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/056bf902-87bb-43f7-84c7-5eaa969ad36a/%ED%8C%8C%EC%A3%BC_DMZ.jpg?id=82fac830-6eba-411f-a6ff-a36cf9cf8d18&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=I0KVb1LOsrJpV2czX7ybuG8d3N7dCx3AiRjdIOnpLig&downloadName=%ED%8C%8C%EC%A3%BC+DMZ.jpg");
		l4.getImage().add("https://file.notion.so/f/f/8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6/056bf902-87bb-43f7-84c7-5eaa969ad36a/%ED%8C%8C%EC%A3%BC_DMZ.jpg?id=82fac830-6eba-411f-a6ff-a36cf9cf8d18&table=block&spaceId=8c2f1236-d0db-4ddc-bef1-ca9b7c92dbd6&expirationTimestamp=1699084800000&signature=I0KVb1LOsrJpV2czX7ybuG8d3N7dCx3AiRjdIOnpLig&downloadName=%ED%8C%8C%EC%A3%BC+DMZ.jpg");
		this.landmarkRepository.save(l4);
	}
}