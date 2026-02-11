import { useState, useEffect } from 'react'
import { useParams, useNavigate, Link } from 'react-router-dom'

function AttractionDetails() {
  const { id } = useParams()
  const navigate = useNavigate()
  const [attraction, setAttraction] = useState(null)
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  useEffect(() => {
    async function fetchAttraction() {
      try {
        const token = localStorage.getItem('token')
        const res = await fetch(`http://localhost:8080/api/attractions/${id}`, {
          headers: { 'Authorization': `Bearer ${token}` }
        })
        const data = await res.json()
        if (!res.ok) throw new Error(data.message)
        setAttraction(data)
      } catch (err) {
        setError(err.message)
        if (err.message === 'Unauthorized') {
          localStorage.removeItem('token')
          localStorage.removeItem('email')
          navigate('/login')
        }
      } finally {
        setLoading(false)
      }
    }
    fetchAttraction()
  }, [id, navigate])

  if (loading) {
    return (
      <div className="details-page">
        <div className="loading">Loading...</div>
      </div>
    )
  }

  if (error) {
    return (
      <div className="details-page">
        <div className="details-container">
          <div className="error-message">{error}</div>
          <Link to="/dashboard" className="back-link">← Back to attractions</Link>
        </div>
      </div>
    )
  }

  return (
    <div className="details-page">
      <div className="details-hero">
        <img
          src={attraction.imageUrl}
          alt={attraction.name}
          className="details-image"
          onError={(e) => {
            e.target.onerror = null
            e.target.src = 'https://via.placeholder.com/1200x400?text=Image+Not+Available'
          }}
        />
        <div className="details-hero-overlay">
          <Link to="/dashboard" className="back-button">← Back</Link>
        </div>
      </div>

      <div className="details-container">
        <div className="details-content">
          <span className={`card-category ${attraction.category}`}>
            {attraction.category}
          </span>
          <h1 className="details-title">{attraction.name}</h1>
          <p className="details-city">{attraction.city}, Bosnia & Herzegovina</p>
          <div className="details-divider"></div>
          <p className="details-description">{attraction.description}</p>
        </div>
      </div>
    </div>
  )
}

export default AttractionDetails
