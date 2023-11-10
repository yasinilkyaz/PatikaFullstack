# PRATİK - 4

### 1.film tablosunda bulunan replacement_cost sütununda bulunan birbirinden farklı değerleri sıralayınız.
```
SELECT DISTINCT replacement_cost FROM film
```

### 2.film tablosunda bulunan replacement_cost sütununda birbirinden farklı kaç tane veri vardır?
```
SELECT COUNT (DISTINCT replacement_cost) FROM film
```
> Sonuç 21

### 3.film tablosunda bulunan film isimlerinde (title) kaç tanesini T karakteri ile başlar ve aynı zamanda rating 'G' ye eşittir?

```
SELECT COUNT(title) FROM film
WHERE title LIKE 'T%' AND rating = 'G'
```
> Sonuç 9


### 4.country tablosunda bulunan ülke isimlerinden (country) kaç tanesi 5 karakterden oluşmaktadır?
```
SELECT COUNT(country) FROM country
WHERE country LIKE '_____'
```
> Sonuç 13

### 5.city tablosundaki şehir isimlerinin kaç tanesi 'R' veya r karakteri ile biter?
```
SELECT COUNT(city) FROM city
WHERE city ILIKE '%r'
```
> Sonuç 33