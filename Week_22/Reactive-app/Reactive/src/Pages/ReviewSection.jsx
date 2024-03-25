import React from "react";

const ReviewSection = () => {
  return (
    <section className="trainer-bg classes-flex" id="review">
      <div className="margi50px"></div>
      <div>
        <div className="relative bar-size">
          <p className="section-title margi50px">REVIEW CLIENT</p>
          <div className="bar"></div>
        </div>
      </div>
      <p className="section-content">
        Lorem Ipsum is not simply random text. It has roots in a piece of classical at <br />
        Hampden-Sydney College.
      </p>

      <div className=" US-flex">
        <ReviewCard
          imgSrc="Resimler/client1.jpg"
          alt="ikon"
          metin1="Diet Expert"
          metin2="CFO"
          comment="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis consequatur repudiandae voluptatum, laudantium soluta accusamus accusantium eligendi illum dolores unde, pariatur obcaecati vero suscipit natus optio fugit incidunt rerum! Nihil?"
        />
        <ReviewCard
          imgSrc="Resimler/client2.jpg"
          alt="ikon"
          metin1="Cardio Trainer"
          metin2="CEO"
          comment="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis consequatur repudiandae voluptatum, laudantium soluta accusamus accusantium eligendi illum dolores unde, pariatur obcaecati vero suscipit natus optio fugit incidunt rerum! Nihil?"
        />
      </div>
    </section>
  );
};

const ReviewCard = ({ imgSrc, alt, metin1, metin2, comment }) => {
  return (
    <div className="pl20px">
      <div className="flex-client margi50px">
        <img src={imgSrc} alt={alt} className="ikon" />
        <div>
          <p className="metin1">{metin1}</p>
          <p className="metin2">{metin2}</p>
        </div>
      </div>
      <div className="client-comment">
        <p style={{ fontWeight: 600 }}>{comment}</p>
        <div className="triangle1"></div>
      </div>
    </div>
  );
};

export default ReviewSection;