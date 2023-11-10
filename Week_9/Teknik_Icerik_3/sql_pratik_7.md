# PRATİK - 7

### 1.film tablosunda bulunan filmleri rating değerlerine göre gruplayınız.
```
SELECT rating , COUNT(*) FROM film

GROUP BY rating

ORDER BY rating
```
>Sonuç 
```
"G"	178

"PG"	194

"PG-13"	223

"R"	195

"NC-17"	210
```
### 2.film tablosunda bulunan filmleri replacement_cost sütununa göre grupladığımızda film sayısı 50 den fazla olan replacement_cost değerini ve karşılık gelen film sayısını sıralayınız.
```
SELECT replacement_cost , COUNT(*) FROM film

GROUP BY replacement_cost

HAVİNG COUNT(replacement_cost)>50
```
>Sonuç 
```
13.99	55

20.99	57

27.99	53

29.99	53

12.99	55

14.99	51

22.99	55

21.99	55
```

### 3.customer tablosunda bulunan store_id değerlerine karşılık gelen müşteri sayılarını nelerdir?
```
SELECT store_id , COUNT(*) FROM customer

GROUP BY store_id
```
>Sonuç 
```
1	326 
2	273
```

### 4.city tablosunda bulunan şehir verilerini country_id sütununa göre gruplandırdıktan sonra en fazla şehir sayısı barındıran country_id bilgisini ve şehir sayısını paylaşınız.
```
SELECT country_id, COUNT(*) FROM city

GROUP BY country_id

ORDER BY COUNT(country_id) DESC

LIMIT 5
```

>Sonuç
```
44	60
23	53
103	35
50	31
60	30
```