import React, { useState,useEffect } from "react";
import solo from "/Resimler/solo.jpg";
import stret from "/Resimler/stret.webp";
import yoga from "/Resimler/yoga.jpg";
import group from "/Resimler/group.webp";
const Classes = () => {
  // Her buton için ayrı içerik state'leri oluşturuldu
  const [yogaContent, setYogaContent] = useState(null);
  const [groupContent, setGroupContent] = useState(null);
  const [soloContent, setSoloContent] = useState(null);
  const [stretchingContent, setStretchingContent] = useState(null);

  // Butonlara tıklama işlevi
  const handleButtonClick = (buttonId) => {
    switch (buttonId) {
      case "Yoga":
        setYogaContent(
            <div className="flex">
            <div className="margi50px">
              <h2 style={{ fontWeight: 700 }}>Why are your Yoga?</h2>
              <br />
              <p style={{ fontWeight: 700 }}>
                Lorem, ipsum dolor sit amet consectetur adipisicing elit. Velit
                cumque quia illum neque odit, similique nobis at eligendi nihil
                rerum deserunt rem voluptatum autem numquam sit nesciunt ab
                deleniti officiis?
              </p>
              <br />
              <h2 style={{ fontWeight: 700 }}>When comes Group Your Time.</h2>
              <br />
              <p style={{ fontWeight: 700 }}>
                Saturday-Sunday: 8:00am - 10:00am
              </p>
              <br />
              <p style={{ fontWeight: 700 }}>
                Monday-Tuesday: 10:00am - 12:00pm
              </p>
              <br />
              <p style={{ fontWeight: 700 }}>
                Wednesday-Friday: 3:00pm - 6:00pm
              </p>
            </div>
            <div className="classes-flex">
              <img src={yoga} className="img" />
            </div>
          </div>
        );

        setGroupContent(null);
        setSoloContent(null);
        setStretchingContent(null);
        break;
      case "Group":
        setGroupContent(
          <div className="flex">
            <div className="margi50px">
              <h2 style={{ fontWeight: 700 }}>Why are your Group?</h2>
              <br />
              <p style={{ fontWeight: 700 }}>
                Lorem, ipsum dolor sit amet consectetur adipisicing elit. Velit
                cumque quia illum neque odit, similique nobis at eligendi nihil
                rerum deserunt rem voluptatum autem numquam sit nesciunt ab
                deleniti officiis?
              </p>
              <br />
              <h2 style={{ fontWeight: 700 }}>When comes Group Your Time.</h2>
              <br />
              <p style={{ fontWeight: 700 }}>
                Saturday-Sunday: 8:00am - 10:00am
              </p>
              <br />
              <p style={{ fontWeight: 700 }}>
                Monday-Tuesday: 10:00am - 12:00pm
              </p>
              <br />
              <p style={{ fontWeight: 700 }}>
                Wednesday-Friday: 3:00pm - 6:00pm
              </p>
            </div>
            <div className="classes-flex">
              <img src={group} className="img" />
            </div>
          </div>
        );
        setYogaContent(null);
        setSoloContent(null);
        setStretchingContent(null);
        break;
      case "Solo":
        setSoloContent(
            <div className="flex">
            <div className="margi50px">
              <h2 style={{ fontWeight: 700 }}>Why are your Solo?</h2>
              <br />
              <p style={{ fontWeight: 700 }}>
                Lorem, ipsum dolor sit amet consectetur adipisicing elit. Velit
                cumque quia illum neque odit, similique nobis at eligendi nihil
                rerum deserunt rem voluptatum autem numquam sit nesciunt ab
                deleniti officiis?
              </p>
              <br />
              <h2 style={{ fontWeight: 700 }}>When comes Group Your Time.</h2>
              <br />
              <p style={{ fontWeight: 700 }}>
                Saturday-Sunday: 8:00am - 10:00am
              </p>
              <br />
              <p style={{ fontWeight: 700 }}>
                Monday-Tuesday: 10:00am - 12:00pm
              </p>
              <br />
              <p style={{ fontWeight: 700 }}>
                Wednesday-Friday: 3:00pm - 6:00pm
              </p>
            </div>
            <div className="classes-flex">
              <img src={solo} className="img" />
            </div>
          </div>
        );
        setYogaContent(null);
        setGroupContent(null);
        setStretchingContent(null);
        break;
      case "Stretching":
        setStretchingContent(
            <div className="flex">
            <div className="margi50px">
              <h2 style={{ fontWeight: 700 }}>Why are your Stretching?</h2>
              <br />
              <p style={{ fontWeight: 700 }}>
                Lorem, ipsum dolor sit amet consectetur adipisicing elit. Velit
                cumque quia illum neque odit, similique nobis at eligendi nihil
                rerum deserunt rem voluptatum autem numquam sit nesciunt ab
                deleniti officiis?
              </p>
              <br />
              <h2 style={{ fontWeight: 700 }}>When comes Group Your Time.</h2>
              <br />
              <p style={{ fontWeight: 700 }}>
                Saturday-Sunday: 8:00am - 10:00am
              </p>
              <br />
              <p style={{ fontWeight: 700 }}>
                Monday-Tuesday: 10:00am - 12:00pm
              </p>
              <br />
              <p style={{ fontWeight: 700 }}>
                Wednesday-Friday: 3:00pm - 6:00pm
              </p>
            </div>
            <div className="classes-flex">
              <img src={stret} className="img" />
            </div>
          </div>
        );
        setYogaContent(null);
        setGroupContent(null);
        setSoloContent(null);
        break;
      default:
        break;
    }
  };

  const buttons = ["Yoga", "Group", "Solo", "Stretching"];
  useEffect(() => {
    setYogaContent(
      <div className="flex">
        <div className="margi50px">
          <h2 style={{ fontWeight: 700 }}>Why are your Yoga?</h2>
          <br />
          <p style={{ fontWeight: 700 }}>
            Lorem, ipsum dolor sit amet consectetur adipisicing elit. Velit
            cumque quia illum neque odit, similique nobis at eligendi nihil
            rerum deserunt rem voluptatum autem numquam sit nesciunt ab
            deleniti officiis?
          </p>
          <br />
          <h2 style={{ fontWeight: 700 }}>When comes Group Your Time.</h2>
          <br />
          <p style={{ fontWeight: 700 }}>Saturday-Sunday: 8:00am - 10:00am</p>
          <br />
          <p style={{ fontWeight: 700 }}>Monday-Tuesday: 10:00am - 12:00pm</p>
          <br />
          <p style={{ fontWeight: 700 }}>Wednesday-Friday: 3:00pm - 6:00pm</p>
        </div>
        <div className="classes-flex">
          <img src={yoga} className="img" />
        </div>
      </div>
    );
  }, []);

  return (
    <section id="classes" className="classes-flex classes-bg">
      <div className="margi50px"></div>
      <div>
        <div className="relative bar-size">
          <p className="section-title margi50px"> OUR CLASSES</p>
          <div className="bar"></div>
        </div>
      </div>
      <p className="section-content">
        Lorem Ipsum is not simply random text. It has roots in a piece of
        classical at <br />
        Hampden-Sydney College.
      </p>

      <div className="flex margin10px">
        <div className="margin10px">
          {buttons.map((button) => (
            <button
              key={button}
              className="button"
              onClick={() => handleButtonClick(button)}
            >
              {button}
            </button>
          ))}
        </div>
      </div>

      <div className="flex margi50px" id="content">
        <div>{yogaContent}</div>
        <div>{groupContent}</div>
        <div>{soloContent}</div>
        <div>{stretchingContent}</div>
        <div className="classes-flex">{/* Resim buraya eklenecek */}</div>
      </div>
    </section>
  );
};

export default Classes;
