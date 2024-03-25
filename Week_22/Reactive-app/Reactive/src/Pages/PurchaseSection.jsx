import React from "react";

const PurchaseSection = () => {
  return (
    <section className="purchase-bg classes-flex" id="purchase">
      <div className="margi50px"></div>
      <div>
        <div className="relative bar-size">
          <p className="section-title margi50px">PURCHASE FROM US</p>
          <div className="bar"></div>
        </div>
      </div>
      <p className="section-content">
        Lorem Ipsum is not simply random text. It has roots in a piece of classical at <br />
        Hampden-Sydney College.
      </p>

      <div className="card-container">
        <PurchaseCard
          imgSrc="Resimler/purchase1.jpg"
          alt="Koşu Bandı"
          title="Kettlebell / 5kg"
          oldPrice="89,99₺"
          newPrice="/ 59,99$"
        />
        <PurchaseCard
          imgSrc="Resimler/purchase2.jpg"
          alt="Ayarlanabilir Dambıl"
          title="Treadmill"
          oldPrice="89,99₺"
          newPrice="/ 59,99$"
        />
        <PurchaseCard
          imgSrc="Resimler/purchase3.jpg"
          alt=""
          title="Adjustable Dumbbell"
          oldPrice="89,99₺"
          newPrice="/ 59,99$"
        />
        <PurchaseCard
          imgSrc="Resimler/purchase4.jpg"
          alt="3kg Kettlebell"
          title="Kettlebell / 3kg"
          oldPrice="89,99₺"
          newPrice="/ 59,99$"
        />
      </div>
    </section>
  );
};

const PurchaseCard = ({ imgSrc, alt, title, oldPrice, newPrice }) => {
  return (
    <div className="card">
      <img src={imgSrc} alt={alt} />
      <div className="card-content">
        <h3 className="card-title">{title}</h3>
        <p className="card-p">
          <span className="eski-fiyat">{oldPrice}</span>{" "}
          <span className="yeni-fiyat">{newPrice}</span>
        </p>
        <i className="fa-solid fa-cart-shopping"></i>
        <button className="sepete-ekle">Sepete Ekle</button>
      </div>
    </div>
  );
};

export default PurchaseSection;
