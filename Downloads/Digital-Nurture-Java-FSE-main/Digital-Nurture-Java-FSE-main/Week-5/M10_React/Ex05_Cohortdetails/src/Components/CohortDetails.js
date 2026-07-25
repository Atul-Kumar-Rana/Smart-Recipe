import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ name, status, startDate, endDate }) => {
  // Define dynamic style for h3: green if ongoing, blue otherwise
  const titleStyle = {
    color: status.toLowerCase() === 'ongoing' ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <h3 style={titleStyle}>{name}</h3>
      <dl style={{ textAlign: 'left' }}>
        <dt>Status:</dt>
        <dd>{status}</dd>
        
        <dt>Start Date:</dt>
        <dd>{startDate}</dd>

        <dt>End Date:</dt>
        <dd>{endDate}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
