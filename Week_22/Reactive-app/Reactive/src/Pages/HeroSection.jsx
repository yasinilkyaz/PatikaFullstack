import React from 'react';
import SectionMini from '../Components/SectionMini';

const HeroSection = () => {
    return (
        <>
        <div className="hero hero-section">
            <div>
                <div className="">
                    <span id="powerfull">POWERFULL</span>
                    <p className="heroTitle">Group</p>
                    <p className="heroTitle">Practice </p>
                    <p className="heroTitle">With Trainer </p>
                </div>
                <div className="transparent-bg-color">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis doloremque minima quam eveniet delectus autem labore tenetur necessitatibus repudiandae, praesentium rerum alias aperiam cumque nihil sunt, error dolore perferendis.
                </div>
            </div>
            <div className="flex-only">
                <span id="sign-up">Sign Up</span>
                <span id="details">Details</span>
            </div>
        </div>
            <SectionMini />
        </>
    );
};

export default HeroSection;