# PRATİK - 12
### 1.film tablosunda film uzunluğu length sütununda gösterilmektedir. Uzunluğu ortalama film uzunluğundan fazla kaç tane film vardır?
```
SELECT COUNT(length) FROM film
WHERE length > (SELECT AVG(length) FROM film)
```
>Sonuç 489

### 2.film tablosunda en yüksek rental_rate değerine sahip kaç tane film vardır?
```
SELECT COUNT(rental_rate),rental_rate FROM film
GROUP BY rental_rate
ORDER BY rental_rate DESC
LIMIT 1
```
>Sonuç 336	4.99



### 3.film tablosunda en düşük rental_rate ve en düşün replacement_cost değerlerine sahip filmleri sıralayınız.
```
SELECT title,rental_rate,replacement_cost FROM film
WHERE rental_rate=(SELECT MIN(rental_rate)FROM film) AND
replacement_cost=(SELECT MIN(replacement_cost)FROM film)
```
>Sonuç 15 film

### 4.payment tablosunda en fazla sayıda alışveriş yapan müşterileri(customer) sıralayınız.
```
SELECT payment.customer_id , COUNT(payment.customer_id) FROM payment
GROUP BY payment.customer_id
ORDER BY COUNT(customer_id) DESC
LIMIT 5
```
>Sonuç
>
>148	45,
>
>526	42,
> 
>144	40,
> 
>75 	39,
> 
>236	39,

