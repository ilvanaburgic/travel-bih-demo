import { useState, useEffect } from 'react'
import { useNavigate, Link } from 'react-router-dom'
import { getAttractions } from '../api'

function Dashboard() {
  const [attractions, setAttractions] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')
  const navigate = useNavigate()
  const email = localStorage.getItem('email')

  useEffect(() => {
    async function fetchData() {
      try {
        const token = localStorage.getItem('token')
        const data = await getAttractions(token)
        setAttractions(data)
      } catch (err) {
        setError(err.message)
        if (err.message === 'Unauthorized') {
          handleLogout()
        }
      } finally {
        setLoading(false)
      }
    }
    fetchData()
  }, [])

  function handleLogout() {
    localStorage.removeItem('token')
    localStorage.removeItem('email')
    navigate('/login')
  }

  return (
    <div className="dashboard">
      <nav className="navbar">
        <h1>Travel BiH</h1>
        <div className="navbar-right">
          <span className="user-email">{email}</span>
          <button className="btn-logout" onClick={handleLogout}>
            Logout
          </button>
        </div>
      </nav>

      <div className="container">
        <h2 className="page-title">Discover Bosnia & Herzegovina</h2>

        {loading && <div className="loading">Loading attractions...</div>}

        {error && <div className="error-message">{error}</div>}

        <div className="cards-grid">
          {attractions.map((attraction) => (
            <Link
              key={attraction.id}
              to={`/attraction/${attraction.id}`}
              className="card"
            >
              <img
                src={attraction.imageUrl}
                alt={attraction.name}
                className="card-image"
                onError={(e) => {
                  e.target.onerror = null
                  e.target.style.display = 'none'
                }}
              />
              <div className="card-content">
                <span className={`card-category ${attraction.category}`}>
                  {attraction.category}
                </span>
                <h3 className="card-title">{attraction.name}</h3>
                <p className="card-city">{attraction.city}</p>
              </div>
            </Link>
          ))}
        </div>
      </div>
    </div>
  )
}

export default Dashboard
