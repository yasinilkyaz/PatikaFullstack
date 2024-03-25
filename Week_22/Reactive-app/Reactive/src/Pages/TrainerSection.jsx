import React from "react";

const TrainerSection = () => {
  return (
    <section className="trainer-bg classes-flex" id="trainer">
      <div className="margi50px"></div>
      <div>
        <div className="relative bar-size">
          <p className="section-title margi50px">OUR BEST TRAINERS</p>
          <div className="bar"></div>
        </div>
      </div>
      <p className="section-content">
        Lorem Ipsum is not simply random text. It has roots in a piece of classical at <br />
        Hampden-Sydney College.
      </p>
      <div className="flex margi50px">
        <TrainerCard
          imgSrc="Resimler/trainer1.jpg"
          name="Marry Doe"
          specialty="Yoga Trainer"
        />
        <div className="margin10px"></div>
        <TrainerCard
          imgSrc="Resimler/trainer2.jpg"
          name="Ersin Mutlu"
          specialty="Body Builder"
        />
        <div className="margin10px"></div>
        <TrainerCard
          imgSrc="Resimler/trainer3.jpg"
          name="Jane Doe"
          specialty="Cardio Trainer"
        />
      </div>
    </section>
  );
};

const TrainerCard = ({ imgSrc, name, specialty }) => {
  return (
    <div className="trainer-card">
      <div className="trainer-img">
        <img src={imgSrc} alt="" />
        <div className="border-img"></div>
        <div className="border-img-line"></div>
        <div className="border-img-line2"></div>
        <div className="mavi-div">
          <h3>{name}</h3>
          <p>{specialty}</p>
        </div>
      </div>
    </div>
  );
};

export default TrainerSection;